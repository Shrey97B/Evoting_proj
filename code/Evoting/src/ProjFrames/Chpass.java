package ProjFrames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import Services.DBconn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Chpass extends javax.swing.JFrame {

    /**
     * Creates new form Chpass
     */
    String userid;
    String usertype;
    Connection conn;
    public Chpass(String us,String ustype) {
        userid=us;
        usertype=ustype;
        try {
            conn= (new DBconn()).getDBconnection();
        } catch (Exception ex) {
            Logger.getLogger(Chpass.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        jLabel3.setText(userid);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Oldptx = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Newptx = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        CNewptx = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHANGE PASSWORD");
        getContentPane().add(jLabel1);
        
        
        javax.swing.JPanel pnl = new javax.swing.JPanel();
        pnl.setPreferredSize(new Dimension(800,50));
        getContentPane().add(pnl);
        
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jPanel1.setLayout(new GridLayout(4,1));

        javax.swing.JPanel jPanel11 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel12 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel13 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel14 = new javax.swing.JPanel();
        
        jPanel11.setLayout(new FlowLayout());
        jPanel12.setLayout(new FlowLayout());
        jPanel13.setLayout(new FlowLayout());
        jPanel14.setLayout(new FlowLayout());
        
        jLabel2.setText("User ID:");
        jPanel11.add(jLabel2);
        jPanel11.add(jLabel3);
        
        jPanel1.add(jPanel11);

        jLabel4.setText("Old Password:");
        jPanel12.add(jLabel4);

        Oldptx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OldptxActionPerformed(evt);
            }
        });
        Oldptx.setPreferredSize(new Dimension(112,28));
        jPanel12.add(Oldptx);
        jPanel1.add(jPanel12);

        jLabel5.setText("New Password:");
        jPanel13.add(jLabel5);

        Newptx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewptxActionPerformed(evt);
            }
        });
        
        Newptx.setPreferredSize(new Dimension(112,28));
        jPanel13.add(Newptx);
        jPanel1.add(jPanel13);
        
        jLabel6.setText("Confirm password:");
        jPanel14.add(jLabel6);

        CNewptx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNewptxActionPerformed(evt);
            }
        });

        CNewptx.setPreferredSize(new Dimension(112,28));
        jPanel14.add(CNewptx);
        jPanel1.add(jPanel14);
        
        getContentPane().add(jPanel1);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("APPLY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        getContentPane().add(new javax.swing.JPanel());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OldptxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OldptxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OldptxActionPerformed

    private void NewptxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewptxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewptxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          String oldp = Oldptx.getText();
          String newp = Newptx.getText();
          String cp = CNewptx.getText();
          if(!newp.equals(cp)){
          
            JOptionPane.showMessageDialog(this,"Make sure that new Password and confirmed password are same.");
          }
          else{
              if(newp.equals("")){
                JOptionPane.showMessageDialog(this,"Invalid entry of New password");
              }
              else{
                   try{
          Statement s5 = conn.createStatement();
          String fetch="";
          if(usertype.equals("organizer"))
            fetch = "SELECT userid, password FROM organizacc WHERE userid=\"" + userid + "\"";
          else if(usertype.equals("user"))
            fetch = "SELECT userid, password FROM users WHERE userid=\"" + userid + "\""; 
          String user="";
          ResultSet rsq = s5.executeQuery(fetch);
          boolean b1 = false;
          while(rsq.next()){
              if(oldp.equals(rsq.getString(2))){
                b1=true;
                user = rsq.getString(1);
              }
          
          }
          if(b1){
              String makec="";
              if(usertype.equals("organizer"))
                   makec = "UPDATE organizacc SET password=\"" + newp + "\" WHERE userid=\"" + userid + "\""; 
              else if(usertype.equals("user"))
                   makec = "UPDATE users SET password=\"" + newp + "\" WHERE userid=\"" + userid + "\"";
              s5.executeUpdate(makec);
              JOptionPane.showMessageDialog(this,"Password changed");
          }
          else{
          JOptionPane.showMessageDialog(this,"Please enter proper old Password");
          }
                    }
          catch(Exception e){
          System.out.println("Connection error" + e);
          }
              }
          }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CNewptxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNewptxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CNewptxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chpass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CNewptx;
    private javax.swing.JTextField Newptx;
    private javax.swing.JTextField Oldptx;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
