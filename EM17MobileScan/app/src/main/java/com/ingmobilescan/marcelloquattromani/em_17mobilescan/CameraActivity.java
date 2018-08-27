package com.ingmobilescan.marcelloquattromani.em_17mobilescan;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.VibrationEffect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;
import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.zxing.Result;
import com.ingmobilescan.marcelloquattromani.em_17mobilescan.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.w3c.dom.Text;


public class CameraActivity extends AppCompatActivity {

    private CodeScanner mCodeScanner;
    private CodeScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        LoginActivity user = new LoginActivity();

        Toast.makeText(this,"Benvenuto, " + user.getUsername(),Toast.LENGTH_LONG).show();

        scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);

        final Context mContext = getBaseContext();


        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        new RichiestaAsincrona(result.getText()).execute();
                    }
                });
            }

        });


        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    private class RichiestaAsincrona extends AsyncTask <String,String,Integer>{
        String codice;
        Connection conn;
        private String username = LoginActivity.getUsername();

        RichiestaAsincrona(String codice)
        {
            this.codice = codice;
        }

        public int checkTicket(String qrCodeResult)
        {
            int flag = -1;
            Connection conn;
            PreparedStatement ps;
            ResultSet rs;
            String q = "SELECT IDSICUREZZA FROM ADDSICUREZZA WHERE USERNAME = ?";
            int IDSecurity=-1;
            try {
                conn = DBConnect.getConnection();
                ps = conn.prepareStatement(q);
                ps.setString(1, username);
                rs = ps.executeQuery();
                if(rs.next())
                    IDSecurity = rs.getInt(1);
                else
                {
                    flag = 5;
                }

            }
            catch (SQLException e)
            {
                flag = 4;
            }



            String query ="SELECT BARCODE FROM BIGLIETTO WHERE BARCODE = ?";
            String qrCode = qrCodeResult;
            try {
                conn = DBConnect.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, qrCode);
                rs = ps.executeQuery();
                if(rs.next())
                {
                    flag = 1; //il qrcode è valido
                    query = "SELECT ADDSICUREZZA FROM BIGLIETTO WHERE BARCODE = ? AND ADDSICUREZZA IS NOT NULL";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, qrCode);
                    rs = ps.executeQuery();
                    if(rs.next())
                    {
                        flag = 2; //l'addetto ha già controllato questo biglietto
                    }
                    else
                    {
                        flag = 3; //biglietto valido e non ancora controllato
                        query = "UPDATE BIGLIETTO SET ADDSICUREZZA = ? WHERE BARCODE = ? AND ADDSICUREZZA IS NULL";
                        ps = conn.prepareStatement(query);
                        ps.setInt(1,IDSecurity);
                        ps.setString(2, qrCode);
                        ps.executeUpdate();
                    }
                }
                else {
                    flag = 0;
                }
                conn.close();
                ps.close();
                rs.close();
            }
            catch (SQLException e)
            {
                flag = 4;
            }
            return flag;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            Integer flag = checkTicket(this.codice);
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            // Vibrate for 500 milliseconds
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(100,VibrationEffect.DEFAULT_AMPLITUDE));
            }else{
                //deprecated in API 26
                v.vibrate(100);
            }
            return flag;
        }


        @Override
        protected void onPostExecute(Integer flag) {
            super.onPostExecute(flag);
            if(flag == 2)
                Toast.makeText(getBaseContext(),"ATTENZIONE: biglietto già utilizzato.",Toast.LENGTH_SHORT).show();
            else if(flag == 0)
                Toast.makeText(getBaseContext(), "BIGLIETTO NON VALIDO.", Toast.LENGTH_SHORT).show();
            else if(flag == 3) {
                Toast.makeText(getApplicationContext(),"BIGLIETTO VALIDO.", Toast.LENGTH_SHORT).show();
            }
            else if(flag == 4)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(CameraActivity.this);
                builder.setMessage("Errore nel Database")
                        .setTitle("Eccezione SQL");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else if(flag == 5) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CameraActivity.this);
                builder.setMessage("Addetto sicurezza non registrato")
                        .setTitle("ATTENZIONE");
                AlertDialog dialog = builder.create();
                dialog.show();
            }

        }
    }

}