/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GeneralController;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author giuli
 */
public class EventView extends javax.swing.JFrame implements Observer {

    String event;
    /**
     * Creates new form EventView
     */
    public EventView() {
        
        initComponents();
        jPanelAdvSearch.setVisible(false);
        buttonAdvSearch.setActionCommand("ADVSEARCH");
        buttonUndoSearch.setActionCommand("BACKSEARCH");
        
    }
    
    public String getEventNameText()
    {
        event = textSearchEvent.getText();
        return event;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSearchEvent = new javax.swing.JTable();
        buttonAdvSearch = new javax.swing.JButton();
        buttonOkSearchEvent = new javax.swing.JButton();
        textSearchEvent = new javax.swing.JTextField();
        buttonCreateEvent = new javax.swing.JButton();
        jPanelAdvSearch = new javax.swing.JPanel();
        comboTypeEventSearch = new javax.swing.JComboBox<>();
        textCodeEventSearch = new javax.swing.JTextField();
        textNameEventSearch = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        buttonUndoSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Date", "Places Available", "Code Event", "Price", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableSearchEvent);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 560, 280));

        buttonAdvSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        buttonAdvSearch.setText("Advanced Search");
        buttonAdvSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdvSearchActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAdvSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 30));

        buttonOkSearchEvent.setText("Ok");
        jPanel1.add(buttonOkSearchEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 30, 30));

        textSearchEvent.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        textSearchEvent.setForeground(new java.awt.Color(153, 153, 153));
        textSearchEvent.setText("Search Events Here...");
        textSearchEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textSearchEventMouseClicked(evt);
            }
        });
        textSearchEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSearchEventActionPerformed(evt);
            }
        });
        textSearchEvent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSearchEventKeyPressed(evt);
            }
        });
        jPanel1.add(textSearchEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 30));

        buttonCreateEvent.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        buttonCreateEvent.setText("Create Event");
        jPanel1.add(buttonCreateEvent, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 120, 30));

        jPanelAdvSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboTypeEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type Event...", "Sport", "Cinema", "Teatro", "Concerto", "Museo" }));
        jPanelAdvSearch.add(comboTypeEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 30));

        textCodeEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        textCodeEventSearch.setForeground(new java.awt.Color(153, 153, 153));
        textCodeEventSearch.setText("Code Event");
        jPanelAdvSearch.add(textCodeEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 30));

        textNameEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        textNameEventSearch.setForeground(new java.awt.Color(153, 153, 153));
        textNameEventSearch.setText("Name Event");
        jPanelAdvSearch.add(textNameEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 150, 30));
        jPanelAdvSearch.add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 30, 30));
        jPanelAdvSearch.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 150, 30));

        buttonUndoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUndoSearchActionPerformed(evt);
            }
        });
        jPanelAdvSearch.add(buttonUndoSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 30, 30));

        jPanel1.add(jPanelAdvSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 540, 90));

        jTabbedPane2.addTab("Events", jPanel1);

        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSearchEventActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchEventActionPerformed

    private void buttonAdvSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdvSearchActionPerformed
        textSearchEvent.setVisible(false);
        buttonAdvSearch.setVisible(false);
        buttonCreateEvent.setVisible(false);
        buttonOkSearchEvent.setVisible(false);
        jPanelAdvSearch.setVisible(true);
    }//GEN-LAST:event_buttonAdvSearchActionPerformed

    private void textSearchEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textSearchEventMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchEventMouseClicked

    private void textSearchEventKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchEventKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchEventKeyPressed

    private void buttonUndoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUndoSearchActionPerformed
       /*
        textSearchEvent.setVisible(true);
        buttonAdvSearch.setVisible(true);
        buttonCreateEvent.setVisible(true);
        buttonOkSearchEvent.setVisible(true);
        jPanelAdvSearch.setVisible(false);
        */
    }//GEN-LAST:event_buttonUndoSearchActionPerformed

    public void setControllerButtonOkSearchEvent(GeneralController nuovo)
    {
        buttonOkSearchEvent.addActionListener(nuovo);
    }

    public JButton getButtonAdvSearch() {
        return buttonAdvSearch;
    }

    public void setButtonAdvSearch(JButton buttonAdvSearch) {
        this.buttonAdvSearch = buttonAdvSearch;
    }

    public JButton getButtonCreateEvent() {
        return buttonCreateEvent;
    }

    public void setButtonCreateEvent(JButton buttonCreateEvent) {
        this.buttonCreateEvent = buttonCreateEvent;
    }

    public JButton getButtonOkSearchEvent() {
        return buttonOkSearchEvent;
    }

    public void setButtonOkSearchEvent(JButton buttonOkSearchEvent) {
        this.buttonOkSearchEvent = buttonOkSearchEvent;
    }
    
    public void setControllerEvent(GeneralController contr)
     {
         buttonAdvSearch.addActionListener(contr);
         buttonUndoSearch.addActionListener(contr);
         
    }

    public JPanel getjPanelAdvSearch() {
        return jPanelAdvSearch;
    }

    public void setjPanelAdvSearch(JPanel jPanelAdvSearch) {
        this.jPanelAdvSearch = jPanelAdvSearch;
    }

    public JTextField getTextSearchEvent() {
        return textSearchEvent;
    }

    public void setTextSearchEvent(JTextField textSearchEvent) {
        this.textSearchEvent = textSearchEvent;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdvSearch;
    private javax.swing.JButton buttonCreateEvent;
    private javax.swing.JButton buttonOkSearchEvent;
    private javax.swing.JButton buttonSearch;
    private javax.swing.JButton buttonUndoSearch;
    private javax.swing.JComboBox<String> comboTypeEventSearch;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdvSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable tableSearchEvent;
    private javax.swing.JTextField textCodeEventSearch;
    private javax.swing.JTextField textNameEventSearch;
    private javax.swing.JTextField textSearchEvent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object risultato) {
        Integer errore = (Integer) risultato;
            if(errore == 0)
            {
              JOptionPane.showMessageDialog(this, "evento", "ERRORE", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //SETVISIBILE TRUE HOME.
                this.dispose();    
            }
    }
}
