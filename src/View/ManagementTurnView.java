/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GestioneTabella.MyDefaultTableModel;
import GestioneTabella.MyTableCellRenderer;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author giuli
 */
public class ManagementTurnView extends javax.swing.JPanel {

    /**
     * Creates new form MenagementEvents
     */
    MyDefaultTableModel tab;
    
    public ManagementTurnView() {
        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        buttonCreateWork.setActionCommand("CREATE");
        buttonDeleteWork.setActionCommand("DELETE");
        buttonSearchWork.setActionCommand("SEARCH");
        buttonLoadEventWork.setActionCommand("LOADEVENT");
        buttonLoadTaxWork.setActionCommand("LOADTAX");
        tableMenagementEvents.setDefaultRenderer(Object.class,new MyTableCellRenderer());
        buttonDeleteWork.setEnabled(false);
        comboEventWork.setEnabled(false);
        comboTaxCodeWork.setEnabled(false);
        refreshNamesColumn();
    }

    public JButton getButtonCreate() {
        return buttonCreateWork;
    }

    public void setButtonCreate(JButton buttonCreate) {
        this.buttonCreateWork = buttonCreate;
    }

    public JButton getButtonDelete() {
        return buttonDeleteWork;
    }

    public void setButtonDelete(JButton buttonDelete) {
        this.buttonDeleteWork = buttonDelete;
    }

    public JSpinner getSpinnerEnd() {
        return spinnerEnd;
    }

    public void setSpinnerEnd(JSpinner spinnerEnd) {
        this.spinnerEnd = spinnerEnd;
    }

    public JSpinner getSpinnerStart() {
        return spinnerStart;
    }

    public void setSpinnerStart(JSpinner spinnerStart) {
        this.spinnerStart = spinnerStart;
    }

    public JButton getButtonSearch() {
        return buttonSearchWork;
    }

    public void setButtonSearch(JButton buttonSearch) {
        this.buttonSearchWork = buttonSearch;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JTable getTableMenagementEvents() {
        return tableMenagementEvents;
    }

    public void setTableMenagementEvents(JTable tableMenagementEvents) {
        this.tableMenagementEvents = tableMenagementEvents;
    }

    public JComboBox<String> getComboEventWork() {
        return comboEventWork;
    }

    public void setComboEventWork(JComboBox<String> comboEventWork) {
        this.comboEventWork = comboEventWork;
    }

    public JComboBox<String> getComboTaxCodeWork() {
        return comboTaxCodeWork;
    }

    public void setComboTaxCodeWork(JComboBox<String> comboTaxCodeWork) {
        this.comboTaxCodeWork = comboTaxCodeWork;
    }

    public JTextField getTextSurnameSecurityWork() {
        return textSurnameSecurityWork;
    }

    public void setTextSurnameSecurityWork(JTextField textSurnameSecurityWork) {
        this.textSurnameSecurityWork = textSurnameSecurityWork;
    }

    public JTextField getTextTitleEventWork() {
        return textTitleEventWork;
    }

    public JButton getButtonLoadEventWork() {
        return buttonLoadEventWork;
    }

    public void setButtonLoadEventWork(JButton buttonLoadEventWork) {
        this.buttonLoadEventWork = buttonLoadEventWork;
    }

    public JButton getButtonLoadTaxWork() {
        return buttonLoadTaxWork;
    }

    public void setButtonLoadTaxWork(JButton buttonLoadTaxWork) {
        this.buttonLoadTaxWork = buttonLoadTaxWork;
    }

    public void setTextTitleEventWork(JTextField textTitleEventWork) {
        this.textTitleEventWork = textTitleEventWork;
    }

    public void refreshNamesColumn(){
        //Aggiorno i nomi delle colonne nella view 
         tableMenagementEvents.getColumnModel().getColumn(4).setHeaderValue("START TURN");
         tableMenagementEvents.getColumnModel().getColumn(5).setHeaderValue("END TURN");
         tableMenagementEvents.getColumnModel().getColumn(6).setHeaderValue("TURN NUMBER");
    }
    
    public void updateTable(Set obj)
    {
         tab = new MyDefaultTableModel();
         tab.createModelBySetTurn((Set) obj);//da aggiungere nuovo metodo dentro a my default tabe model che carica questi.
         
         tableMenagementEvents.setModel(tab);
         int id = tableMenagementEvents.getColumnModel().getColumnIndex("TURN_NUMBER");
         tab.setId_column(id);
         tableMenagementEvents.setRowSorter(new TableRowSorter (tab));
         refreshNamesColumn();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableMenagementEvents = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        buttonDeleteWork = new javax.swing.JButton();
        buttonCreateWork = new javax.swing.JButton();
        buttonSearchWork = new javax.swing.JButton();
        spinnerStart = new javax.swing.JSpinner();
        spinnerEnd = new javax.swing.JSpinner();
        textSurnameSecurityWork = new javax.swing.JTextField();
        textTitleEventWork = new javax.swing.JTextField();
        comboTaxCodeWork = new javax.swing.JComboBox<>();
        comboEventWork = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonLoadTaxWork = new javax.swing.JButton();
        buttonLoadEventWork = new javax.swing.JButton();
        sfondo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(600, 800));
        setMinimumSize(new java.awt.Dimension(600, 800));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(600, 800));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setOpaque(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 600));

        tableMenagementEvents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "SURNAME", "TITLE", "DATE", "START_TURN", "END_TURN", "TURN_NUMBER"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMenagementEvents.setOpaque(false);
        jScrollPane1.setViewportView(tableMenagementEvents);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 690, 450));

        jLabel3.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CODE EVENT");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 160, 20));

        jLabel6.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("FROM HOUR");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 80, 20));

        jLabel7.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TO HOUR");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 80, 20));

        jLabel8.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TAX CODE SECURITY");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 160, 20));

        buttonDeleteWork.setBackground(new java.awt.Color(255, 204, 104));
        buttonDeleteWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        buttonDeleteWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/delete.png"))); // NOI18N
        add(buttonDeleteWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 40, 30));

        buttonCreateWork.setBackground(new java.awt.Color(255, 204, 104));
        buttonCreateWork.setFont(new java.awt.Font("Dubai Medium", 1, 8)); // NOI18N
        buttonCreateWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/toWork.png"))); // NOI18N
        buttonCreateWork.setText("SET WORK");
        add(buttonCreateWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 110, 30));

        buttonSearchWork.setBackground(new java.awt.Color(255, 204, 104));
        buttonSearchWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        buttonSearchWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/okButton.png"))); // NOI18N
        buttonSearchWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSearchWorkActionPerformed(evt);
            }
        });
        add(buttonSearchWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 40, 30));

        spinnerStart.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        add(spinnerStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 80, 30));

        spinnerEnd.setModel(new javax.swing.SpinnerNumberModel(1, 1, 24, 1));
        add(spinnerEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 80, 30));

        textSurnameSecurityWork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSurnameSecurityWorkActionPerformed(evt);
            }
        });
        add(textSurnameSecurityWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 30));
        add(textTitleEventWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 130, 30));

        comboTaxCodeWork.setBackground(new java.awt.Color(255, 204, 104));
        comboTaxCodeWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        add(comboTaxCodeWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 160, 30));

        comboEventWork.setBackground(new java.awt.Color(255, 204, 104));
        comboEventWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        add(comboEventWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 160, 30));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EVENT TITLE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 20));

        jLabel2.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SURNAME OFFICER");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 20));

        buttonLoadTaxWork.setBackground(new java.awt.Color(255, 204, 104));
        buttonLoadTaxWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        buttonLoadTaxWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/loading.png"))); // NOI18N
        add(buttonLoadTaxWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 40, 30));

        buttonLoadEventWork.setBackground(new java.awt.Color(255, 204, 104));
        buttonLoadEventWork.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        buttonLoadEventWork.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/loading.png"))); // NOI18N
        add(buttonLoadEventWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 40, 30));

        sfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picture/pastello.jpg"))); // NOI18N
        sfondo.setOpaque(true);
        add(sfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 1000));
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSearchWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSearchWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSearchWorkActionPerformed

    private void textSurnameSecurityWorkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSurnameSecurityWorkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSurnameSecurityWorkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCreateWork;
    private javax.swing.JButton buttonDeleteWork;
    private javax.swing.JButton buttonLoadEventWork;
    private javax.swing.JButton buttonLoadTaxWork;
    private javax.swing.JButton buttonSearchWork;
    private javax.swing.JComboBox<String> comboEventWork;
    private javax.swing.JComboBox<String> comboTaxCodeWork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sfondo;
    private javax.swing.JSpinner spinnerEnd;
    private javax.swing.JSpinner spinnerStart;
    private javax.swing.JTable tableMenagementEvents;
    private javax.swing.JTextField textSurnameSecurityWork;
    private javax.swing.JTextField textTitleEventWork;
    // End of variables declaration//GEN-END:variables
}
