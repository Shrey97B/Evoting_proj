package ProjFrames;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import Services.DBconn;

/**
 *
 * @author Acer
 */
public class Feedback extends javax.swing.JFrame {
    private PreparedStatement stmt;

    /**
     * Creates new form Feedback
     */
    
    
    public Feedback(String str1, String str2) {
        initComponents();
        userid=str1;
        designation=str2;
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
        txtarea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new FlowLayout());
        
        jPanel1.setLayout(new BoxLayout(jPanel1,BoxLayout.Y_AXIS));

        txtarea.setColumns(20);
        txtarea.setRows(5);
        jScrollPane1.setViewportView(txtarea);
        
        javax.swing.JPanel pnl = new javax.swing.JPanel();
        pnl.setPreferredSize(new Dimension(700,25));
        jPanel1.add(pnl);
        
        jLabel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.add(jLabel3);
        
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        jLabel4.setText("FEEDBACK FORM");
        jPanel1.add(jLabel4);
        
        javax.swing.JPanel pnl2 = new javax.swing.JPanel();
        pnl2.setPreferredSize(new Dimension(700,25));
        jPanel1.add(pnl2);

        jPanel1.add(jScrollPane1);

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SEND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        
        javax.swing.JPanel pnl3 = new javax.swing.JPanel();
        pnl3.setPreferredSize(new Dimension(700,25));
        jPanel1.add(pnl3);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            area = txtarea.getText();

            Connection con = (new DBconn()).getDBconnection();
            //PreparedStatement pss=con.prepareStatement("insert  into reg (name,pass,age,mobile,college,place) values('"+name+"','"+pass+"','"+age+"','"+mobile+"','"+college+"','"+place+");
            PreparedStatement PS = con.prepareStatement("SELECT CURRENT_TIMESTAMP");
            ResultSet rs = PS.executeQuery();
            stmt = con.prepareStatement("insert into feedback values(?,?,?,?)");
            if (rs.next()) {
                stmt.setString(1, userid);
                stmt.setString(2, designation);//1 specifies the first parameter in the query  
                stmt.setString(4, area);
                stmt.setTimestamp(3, rs.getTimestamp(1));
                int sss = stmt.executeUpdate();

                JOptionPane.showMessageDialog(rootPane, "Thank You Your feedback has been saved in database");


            }


            txtarea.setText("");
        } catch (Exception e) {
            System.out.println("Invalid input" + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    String userid,designation,area;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtarea;
    // End of variables declaration//GEN-END:variables
}
