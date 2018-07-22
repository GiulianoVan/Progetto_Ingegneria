/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Runner.RunECBAddetti;
import Runner.RunECBCustomer;
import Runner.RunECBEvents;
import Runner.RunECBManagementTurn;
import Runner.RunStatistics;
import java.awt.Color;


/**
 *
 * @author giuli
 */
public class MainView extends javax.swing.JFrame{

    String event;
    /**
     * Creates new form EventView
     */
    public MainView() {
        
        initComponents();
        RunECBEvents runEvents = new RunECBEvents();
        RunECBAddetti runSecurity = new RunECBAddetti();
        RunECBCustomer runCustomer = new RunECBCustomer();
        RunECBManagementTurn runManagementTurn = new RunECBManagementTurn();
        RunStatistics runStat  = new RunStatistics();
        runEvents.startRunMVCEvents();
        runSecurity.startMVCAddetti();
        runCustomer.startMVCCustomer();
        runManagementTurn.start();
        runStat.start();
        setEventsTabbed(runEvents);
        setCustomersTabbed(runCustomer);
        setSecurityTabbed(runSecurity);
        setManagementTabbed(runManagementTurn);
        setStaticsTabbel(runStat);

        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedMenu = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(830, 570));
        setMinimumSize(new java.awt.Dimension(830, 570));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedMenu.setBackground(new java.awt.Color(140, 207, 255));
        jTabbedMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedMenu.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jTabbedMenu.setMaximumSize(new java.awt.Dimension(830, 570));
        jTabbedMenu.setMinimumSize(new java.awt.Dimension(830, 570));
        jTabbedMenu.setOpaque(true);
        jTabbedMenu.setPreferredSize(new java.awt.Dimension(830, 570));
        getContentPane().add(jTabbedMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void setEventsTabbed(RunECBEvents runEvents)
{
    jTabbedMenu.add("Events",runEvents.getEvtView());
    jTabbedMenu.setIconAt(0, new javax.swing.ImageIcon(getClass().getResource("/Picture/popularParty.png")));
    jTabbedMenu.setBackgroundAt(0, new java.awt.Color(255, 204, 104));
}

private void setCustomersTabbed(RunECBCustomer runCustomer)
{
    
    jTabbedMenu.add("Customers",runCustomer.getCustomerView());  
    jTabbedMenu.setIconAt(1, new javax.swing.ImageIcon(getClass().getResource("/Picture/clients.png")));
    jTabbedMenu.setBackgroundAt(1, new java.awt.Color(255, 204, 104));
}

private void setSecurityTabbed(RunECBAddetti runSecurity)
{
    jTabbedMenu.add("Security",runSecurity.getAddettiView());
    jTabbedMenu.setIconAt(2, new javax.swing.ImageIcon(getClass().getResource("/Picture/securityOfficer.png")));
    jTabbedMenu.setBackgroundAt(2, new java.awt.Color(255, 204, 104));
}

private void setManagementTabbed(RunECBManagementTurn runManagementTurn)
{
    jTabbedMenu.add("Man. Turn",runManagementTurn.getView());
    jTabbedMenu.setIconAt(3, new javax.swing.ImageIcon(getClass().getResource("/Picture/work.png")));
    jTabbedMenu.setBackgroundAt(3, new java.awt.Color(255, 204, 104));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedMenu;
    // End of variables declaration//GEN-END:variables

    private void setStaticsTabbel(RunStatistics runStat) {
        jTabbedMenu.add("Statistics",runStat.getView());
        jTabbedMenu.setIconAt(4, new javax.swing.ImageIcon(getClass().getResource("/Picture/statistic.png")));
        jTabbedMenu.setBackgroundAt(4, new java.awt.Color(255, 204, 104));
    }

    
}
