/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class HomeMember extends javax.swing.JFrame {

    /**
     * Creates new form HomeMember
     */
    public HomeMember() {
        initComponents();
    }

    //untuk tabel
    public int getRowTable() {
        int row = listKomik.getSelectedRow();
        return row;
    }

    public Object getTableValue(int a, int b) {
        Object value = listKomik.getValueAt(a, b);
        return value;
    }

    public void setlist(DefaultTableModel model) {
        listKomik.setModel(model);
    }

    public void setnotif (String x){
        notif.setText(x);
    }
    public int getRowTablePinjam() {
        int row = listPilih.getSelectedRow();
        return row;
    }

    public Object getTablePinjamValue(int a, int b) {
        Object value = listPilih.getValueAt(a, b);
        return value;
    }

    public void setlistPinjam(DefaultTableModel model) {
        listPilih.setModel(model);
    }


    
    //untuk listener tabel
    public void listenerTabelKomik(MouseListener x){
        listKomik.addMouseListener(x);
    }
    
    //untuk pencarian
    public String getKategori() {
        return cbKategori.getSelectedItem().toString();
    }

    public String getCari() {
        return tfCari.getText();
    }
    public void resetText(String x){
        tfCari.setText(x);
    }

    public void listenerCari(ActionListener x) {
        jbCari.addActionListener(x);
    }
                        
    //untuk exit, logout dan kembali
    public void listenerExit(ActionListener X) {
        Jbexit.addActionListener(X);
    }
    public void listenerLogout (ActionListener x){
        jbLogout.addActionListener(x);
    }
    public void listenerBack (ActionListener x){
        jbBack.addActionListener(x);
    }
    
    public void listenerPilih (ActionListener x){
        jbPilih.addActionListener(x);
    }
    public void listenerReset (ActionListener x){
        jbReset.addActionListener(x);
    }
    public void listenerSelesai(ActionListener x){
        jbSelesai.addActionListener(x);
    }
    
    //untuk view gambar
  public void setImage(ImageIcon x) {
        LviewImage.setIcon(x);
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
        listKomik = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        listPilih = new javax.swing.JTable();
        LviewImage = new javax.swing.JLabel();
        jbPilih = new javax.swing.JButton();
        jbReset = new javax.swing.JButton();
        jbSelesai = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();
        jbCari = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbKategori = new javax.swing.JComboBox<>();
        Jbexit = new javax.swing.JButton();
        notif = new javax.swing.JLabel();
        jbLogout = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listKomik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(listKomik);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 450, 420));

        listPilih.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(listPilih);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 420, 140));
        getContentPane().add(LviewImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 270, 230));

        jbPilih.setText("Pilih");
        jbPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPilihActionPerformed(evt);
            }
        });
        getContentPane().add(jbPilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 490, 70, -1));

        jbReset.setText("Reset");
        getContentPane().add(jbReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 70, -1));

        jbSelesai.setText("Selesai");
        getContentPane().add(jbSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, -1, 50));

        tfCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCariActionPerformed(evt);
            }
        });
        getContentPane().add(tfCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 340, -1));

        jbCari.setText("Cari");
        getContentPane().add(jbCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 90, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cari Berdasarkan");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 46, -1, 30));

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "judul", "pengarang", "genre" }));
        getContentPane().add(cbKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 310, -1));

        Jbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit putih.png"))); // NOI18N
        Jbexit.setBorderPainted(false);
        Jbexit.setContentAreaFilled(false);
        Jbexit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit hitam.png"))); // NOI18N
        getContentPane().add(Jbexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        notif.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 300, 20));

        jbLogout.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbLogout.setForeground(new java.awt.Color(255, 255, 255));
        jbLogout.setText("Log out");
        jbLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jbLogout.setBorderPainted(false);
        jbLogout.setContentAreaFilled(false);
        jbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, -1, 30));

        jbBack.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setText("Kembali");
        jbBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/member/2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPilihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbPilihActionPerformed

    private void tfCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCariActionPerformed

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
            java.util.logging.Logger.getLogger(HomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbexit;
    private javax.swing.JLabel LviewImage;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbCari;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbPilih;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbSelesai;
    private javax.swing.JTable listKomik;
    private javax.swing.JTable listPilih;
    private javax.swing.JLabel notif;
    private javax.swing.JTextField tfCari;
    // End of variables declaration//GEN-END:variables
}
