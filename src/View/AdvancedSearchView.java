/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author giuli
 */
public class AdvancedSearchView extends javax.swing.JFrame {

    /**
     * Creates new form AdvancedSearchView
     */
    public AdvancedSearchView() {
        initComponents();
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
        tableAdvSearchEvent = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboTypeEventSearch = new javax.swing.JComboBox<>();
        textCodeEventSearch = new javax.swing.JTextField();
        textNameEventSearch = new javax.swing.JTextField();
        dateEventSearch = new com.toedter.calendar.JDateChooser();
        buttonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableAdvSearchEvent.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        tableAdvSearchEvent.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableAdvSearchEvent);
        if (tableAdvSearchEvent.getColumnModel().getColumnCount() > 0) {
            tableAdvSearchEvent.getColumnModel().getColumn(3).setMinWidth(100);
            tableAdvSearchEvent.getColumnModel().getColumn(3).setMaxWidth(500);
            tableAdvSearchEvent.getColumnModel().getColumn(5).setMinWidth(10);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 185, 510, 260));

        jLabel1.setFont(new java.awt.Font("Dubai Medium", 1, 24)); // NOI18N
        jLabel1.setText("ADVANCED SEARCH");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 30));

        comboTypeEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        comboTypeEventSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type Event...", "Sport", "Cinema", "Teatro", "Concerto", "Museo" }));
        getContentPane().add(comboTypeEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 150, 30));

        textCodeEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        textCodeEventSearch.setForeground(new java.awt.Color(153, 153, 153));
        textCodeEventSearch.setText("Code Event");
        getContentPane().add(textCodeEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 150, 30));

        textNameEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        textNameEventSearch.setForeground(new java.awt.Color(153, 153, 153));
        textNameEventSearch.setText("Name Event");
        getContentPane().add(textNameEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 150, 30));

        dateEventSearch.setFont(new java.awt.Font("Dubai Medium", 0, 12)); // NOI18N
        getContentPane().add(dateEventSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, 30));
        getContentPane().add(buttonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 50, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSearch;
    private javax.swing.JComboBox<String> comboTypeEventSearch;
    private com.toedter.calendar.JDateChooser dateEventSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAdvSearchEvent;
    private javax.swing.JTextField textCodeEventSearch;
    private javax.swing.JTextField textNameEventSearch;
    // End of variables declaration//GEN-END:variables
}