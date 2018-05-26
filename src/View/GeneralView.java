/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Runner.RunMVCAddetti;
import Runner.RunMVCCustomer;
import Runner.RunMVCEvents;
import java.awt.Color;


/**
 *
 * @author giuli
 */
public class GeneralView extends javax.swing.JFrame{

    String event;
    /**
     * Creates new form EventView
     */
    public GeneralView() {
        
        initComponents();
        RunMVCEvents runEvents = new RunMVCEvents();
        RunMVCAddetti runSecurity = new RunMVCAddetti();
        RunMVCCustomer runCustomer = new RunMVCCustomer();
        runEvents.startRunMVCEvents();
        runSecurity.startMVCAddetti();
        runCustomer.startMVCCustomer();     
        setEventsTabbed(runEvents);
        setCustomersTabbed(runCustomer);
        setSecurityTabbed(runSecurity);
      
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
        setMinimumSize(new java.awt.Dimension(720, 600));
        setPreferredSize(new java.awt.Dimension(720, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedMenu.setBackground(new java.awt.Color(140, 207, 255));
        jTabbedMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedMenu.setFont(new java.awt.Font("Dubai Medium", 1, 12)); // NOI18N
        jTabbedMenu.setOpaque(true);
        jTabbedMenu.setPreferredSize(new java.awt.Dimension(750, 600));
        getContentPane().add(jTabbedMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void setEventsTabbed(RunMVCEvents runEvents)
{
    jTabbedMenu.add("Events",runEvents.getEvtView());
    jTabbedMenu.setIconAt(0, new javax.swing.ImageIcon(getClass().getResource("/Picture/popularParty.png")));
    jTabbedMenu.setBackgroundAt(0, new java.awt.Color(255, 222, 177));
}

private void setCustomersTabbed(RunMVCCustomer runCustomer)
{
    
    jTabbedMenu.add("Customers",runCustomer.getCustomerView());  
    jTabbedMenu.setIconAt(1, new javax.swing.ImageIcon(getClass().getResource("/Picture/clients.png")));
    jTabbedMenu.setBackgroundAt(1, new java.awt.Color(255, 222, 177));
}

private void setSecurityTabbed(RunMVCAddetti runSecurity)
{
    jTabbedMenu.add("Security",runSecurity.getAddettiView());
    jTabbedMenu.setIconAt(2, new javax.swing.ImageIcon(getClass().getResource("/Picture/securityOfficer.png")));
    jTabbedMenu.setBackgroundAt(2, new java.awt.Color(255, 222, 177));
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedMenu;
    // End of variables declaration//GEN-END:variables

    
}
