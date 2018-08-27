package com.ingmobilescan.marcelloquattromani.em_17mobilescan;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginActivity extends AppCompatActivity {


    public static String username;
    public static String password;

    public static String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText user = (EditText)findViewById(R.id.usernameText);
        EditText pass = findViewById(R.id.pwdText);


        Button enterButton = findViewById(R.id.loginOK);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = user.getText().toString();
                password = pass.getText().toString();
                new RichiestaAsincrona().execute(username,password);

            }
        });
    }


    public void showCamera()
    {
        Intent intent = new Intent(LoginActivity.this,CameraActivity.class);
        startActivity(intent);
        finish();
    }

    private class RichiestaAsincrona extends AsyncTask<String,String,Integer> {

        Connection conn;


        public int checkSecurity(String username, String pwd)
        {
            ResultSet rs;
            PreparedStatement ps;
            Connection conn;
            String query = "SELECT IDSICUREZZA FROM ADDSICUREZZA WHERE USERNAME = ? AND PASSWORD = sha2(?,256)";
            Integer res= -1;
            try {
                conn = DBConnect.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1,username);
                ps.setString(2,pwd);
                rs = ps.executeQuery();
                if(rs.next())
                    res = 1;
                else
                    res = 0;
                conn.close();
                ps.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                res = 2;
            }
            return res;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            Integer flag = checkSecurity(strings[0],strings[1]);
            return  flag;
        }

        @Override
        protected void onPostExecute(Integer flag) {
            super.onPostExecute(flag);

            if(flag == 1)
                showCamera();
            else if(flag == 2){
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Errore nel Database")
                        .setTitle("Eccezione SQL");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setMessage("Username o password errati. Oppure l'addetto non è registrato.")
                        .setTitle("ATTENZIONE");
                AlertDialog dialog = builder.create();
                dialog.show();


            }

        }
    }

}
