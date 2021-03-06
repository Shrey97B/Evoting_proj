package ProjFrames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
public class VoteFrame extends javax.swing.JFrame {

    /**
     * Creates new form VoteFrame
     */
    String userid,elecid;
    int numcand,index=0;
    String candids[];
    Connection conn;
    public VoteFrame(String str1, String str2) {
        userid=str1;
        elecid=str2;
        initComponents();
        elecidlab.setText(elecid);
        String count="SELECT COUNT(cand_id) FROM elecvotes WHERE electionid='" + elecid + "'";
         try {
            conn=(new DBconn()).getDBconnection();
            Statement stat=conn.createStatement();
        ResultSet rs= stat.executeQuery(count);
        if(rs.next()){
           numcand=rs.getInt(1);
        }
        if(numcand==0){
          candnumlab.setText("0 candidates");
          jButton1.setEnabled(false);
          jButton2.setEnabled(false);
          jButton3.setEnabled(false);
         
          
        }
        else{
          candids=new String[numcand];
          int i=index;
          String quer2="SELECT cand_id FROM elecvotes WHERE electionid='" + elecid + "'";
          Statement stat2=conn.createStatement();
          ResultSet rs2=stat2.executeQuery(quer2);
          while(rs2.next()){
            candids[i]=rs2.getString(1);
            i=i+1;
          }
          dispcan(index);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_dash.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cidlab = new javax.swing.JTextField();
        cnamelab = new javax.swing.JTextField();
        maillab = new javax.swing.JTextField();
        mnumlab = new javax.swing.JTextField();
        gridlab = new javax.swing.JTextField();
        candnumlab = new javax.swing.JLabel();
        elecidlab = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(900,700));
        setResizable(true);
        getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("VOTING");
        getContentPane().add(jLabel1);
        
        jPanel1.setLayout(new FlowLayout());
        
        jButton4.setBackground(new java.awt.Color(0, 0, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);

        jLabel7.setText("Election ID:");
        jPanel1.add(jLabel7);
        
        jPanel1.add(elecidlab);
        getContentPane().add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(new BoxLayout(jPanel2,BoxLayout.Y_AXIS));
        
        javax.swing.JPanel jp21 = new javax.swing.JPanel();
        javax.swing.JPanel jp22 = new javax.swing.JPanel();
        javax.swing.JPanel jp23 = new javax.swing.JPanel();
        javax.swing.JPanel jp24 = new javax.swing.JPanel();
        javax.swing.JPanel jp25 = new javax.swing.JPanel();
        javax.swing.JPanel jp26 = new javax.swing.JPanel();
        
        jp21.setLayout(new FlowLayout());
        jp22.setLayout(new FlowLayout());
        jp23.setLayout(new FlowLayout());
        jp24.setLayout(new FlowLayout());
        jp25.setLayout(new FlowLayout());
        jp26.setLayout(new FlowLayout());
        
        jLabel3.setText("Candidate ID:");
        jp21.add(jLabel3);
        

        cidlab.setEditable(false);
        cidlab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidlabActionPerformed(evt);
            }
        });
        jp21.add(cidlab);
        jPanel2.add(jp21);

        jLabel4.setText("Candidate Name:");
        jp22.add(jLabel4);

        cnamelab.setEditable(false);
        cnamelab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnamelabActionPerformed(evt);
            }
        });
        jp22.add(cnamelab);
        
        jPanel2.add(jp22);

        jLabel2.setText("E-mail ID:");
        jp23.add(jLabel2);
        maillab.setEditable(false);
        jp23.add(maillab);
        jLabel5.setText("Mobile number:");
        jp23.add(jLabel5);
        mnumlab.setEditable(false);
        jp23.add(mnumlab);
        jPanel2.add(jp23);


        jPanel2.add(jp24);

        jLabel8.setText("Group ID:");
        jp25.add(jLabel8);
        gridlab.setEditable(false);
        jp25.add(gridlab);
        jPanel2.add(jp25);
        
        jLabel18.setText("Candidate Image");
        jp26.add(jLabel18);
        
        jp26.add(jLabel6);
        
        jLabel17.setText("Candidate's message");
        jp26.add(jLabel17);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane3.setViewportView(jTextArea1);

        jp26.add(jScrollPane3);
        jPanel2.add(jp26);

        getContentPane().add(jPanel2);

        javax.swing.JPanel jp3 = new javax.swing.JPanel();
        jp3.setLayout(new FlowLayout());
        
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/45215107-left-arrow-icon-internet-button-on-black-background - Copy.jpg"))); // NOI18N
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/640px-Yellow_Arrow_Right.png"))); // NOI18N
        jButton1.setVerifyInputWhenFocusTarget(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jp3.add(jButton1);
        
        candnumlab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        candnumlab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jp3.add(candnumlab);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/45215107-left-arrow-icon-internet-button-on-black-background (1).jpg"))); // NOI18N
        jButton2.setDisabledIcon(null);
        jButton2.setDoubleBuffered(true);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/640px-Yellow_Arrow_Right.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jp3.add(jButton2);

        jButton3.setText("VOTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jp3.add(jButton3);
        
        getContentPane().add(jp3);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void dispcan(int num){
        try {
            candnumlab.setText((num+1) +"/"+numcand+ " Candidate");
            cidlab.setText(candids[num]);
            String quer1="SELECT * FROM users WHERE userid='" + candids[num] + "'";
            Statement stat1=conn.createStatement();
            ResultSet rs1=stat1.executeQuery(quer1);
            while(rs1.next()){
               cnamelab.setText(rs1.getString(3));
               maillab.setText(rs1.getString(4));
               mnumlab.setText(rs1.getString(6));
               gridlab.setText(rs1.getString(5));
            }
            String quer2="SELECT candphoto, candmsg FROM candapp WHERE electionid='" + elecid + "' AND userid='" + candids[num] + "'";
            Statement stat2=conn.createStatement();
            ResultSet rs2=stat2.executeQuery(quer2);
            InputStream in=null;
            if(rs2.next()){
              in=rs2.getBinaryStream(1);
              jTextArea1.setText(rs2.getString(2));
            }
            
            if(in!=null) {
            int i=0;
            File f1=new File("test"+i+".jpg");
            OutputStream f = null;
                f = new FileOutputStream(f1);
            
             i++;
            int c = 0;
                while ((c = in.read()) > -1) {
                    f.write(c);
                }
             
                Image originalImage = ImageIO.read(f1);
		 String path=f1.getAbsolutePath();
		ImageIcon resizeImageJpg = ResizeImage(path);
		//ImageIO.write(resizeImageJpg, "jpg", f1);
                
                jLabel6.setIcon(resizeImageJpg);
            }
            else {
            	jLabel6.setIcon(null);
            }
       
        } catch (SQLException ex) {
            Logger.getLogger(VoteFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VoteFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VoteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public ImageIcon ResizeImage(String ImagePath){
      ImageIcon myImage= new ImageIcon(ImagePath);
      Image img=myImage.getImage();
      Image newimg= img.getScaledInstance(140, 180, Image.SCALE_SMOOTH);
      ImageIcon image=new ImageIcon(newimg);
      return image;
    }
    private void cidlabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidlabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidlabActionPerformed

    private void cnamelabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnamelabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnamelabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(index==0){
          index=numcand-1;
        }
        else{
          index--;
        }
        dispcan(index);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       if(index==numcand-1){
          index=0;
        }
        else{
          index++;
        }
        dispcan(index);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            String quer1="SELECT election_stat FROM elections WHERE electionid='" + elecid + "'";
            Statement stat1=conn.createStatement();
            ResultSet rs1=stat1.executeQuery(quer1);
            String electionstatus="";
            if(rs1.next()){
               electionstatus=rs1.getString(1);
            }
            if(!electionstatus.equals("r")){
              JOptionPane.showMessageDialog(this,"Election has already been closed");
            }
            else{
              String quer2="SELECT votestat FROM voters WHERE election_id='" + elecid + "' AND userid='" + userid + "'";
              Statement stat2=conn.createStatement();
              ResultSet rs2=stat2.executeQuery(quer2);
              String voted="";
              if(rs2.next()){
                voted=rs2.getString(1);
              }
              if(voted.equals("y")){
                JOptionPane.showMessageDialog(this,"You have already voted");
              }
              else{
                String upd1="UPDATE voters SET votestat='y' WHERE election_id='" + elecid + "' AND userid='" + userid + "'";
                Statement stat3=conn.createStatement();
                stat3.executeUpdate(upd1);
                String upd2="UPDATE elecvotes SET votes=(votes+1) WHERE electionid='" + elecid + "' AND cand_id='" + candids[index] + "'";
                Statement stat4=conn.createStatement();
                stat4.executeUpdate(upd2);
                JOptionPane.showMessageDialog(this, "Thank you for voting");
              }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VoteFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new User_dash(userid).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel candnumlab;
    private javax.swing.JTextField cidlab;
    private javax.swing.JTextField cnamelab;
    private javax.swing.JLabel elecidlab;
    private javax.swing.JTextField gridlab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField maillab;
    private javax.swing.JTextField mnumlab;
    // End of variables declaration//GEN-END:variables
}
