/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import GalbertoTuwondila.Source.Image.ImagePreview;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.View;

/**
 *
 * @author Acek
 */
public class HomeAdmin extends javax.swing.JFrame {

    /**
     * Creates new form HomeAdmin
     */
    ImagePreview imagePreview = new ImagePreview();
    session ss = new session();
    
    public HomeAdmin() {
        initComponents();
        jFileChooser1.setAccessory(imagePreview);
        jFileChooser1.addPropertyChangeListener(imagePreview);
    }

    //set enable tombol
    public void setEditEnable(boolean x) {
        jbEdit.setEnabled(x);
    }

    public void setSimpanEnable(boolean x) {
        jbSimpan.setEnabled(x);
    }

   
    public void reloadAllInputs(String x) {
        Date today = new Date();
        SimpleDateFormat sdfday = new SimpleDateFormat("yyyy-M-d");
        setID(x);
        setPengarang(x);
        setJudul(x);
        tfGenre.setSelectedIndex(0);
        setChapter(x);
        jkTerbit.setDateFormatString(sdfday.format(today));
        setPath(x);
    }
    
    public void setID(String x) {
        tfIDkomik.setText(x);
    }
    
    public String getID() {
        return tfIDkomik.getText();
        
    }
    
    public void setPengarang(String x) {
        tfPengarang.setText(x);
    }
    
    public String getPengarang() {
        return tfPengarang.getText();
        
    }
    
    public void setJudul(String x) {
        tfJudul.setText(x);
    }
    
    public void setGenre(String x) {
        tfGenre.setSelectedItem(x);
    }
    
    public void setDate(Date x) {
        jkTerbit.setDate(x);
    }
    
    public String getJudul() {
        return tfJudul.getText();
        
    }
    
    public String getGenre() {
        return tfGenre.getSelectedItem().toString();
    }
    
    public void setChapter(String x) {
        tfChapter.setText(x);
    }
    
    public int getChapter() {
        int chapter = Integer.parseInt(tfChapter.getText());
        return chapter;
        
    }
    
    public String getIsiChapter() {
        return tfChapter.getText();
    }
    
    public String getTerbit() {
        SimpleDateFormat formatdate;
        formatdate = new SimpleDateFormat("yyyy-M-d");
        String tgl = formatdate.format(jkTerbit.getDate());
        return tgl;
        
    }
    
    public void listenerSimpan(ActionListener x) {
        jbSimpan.addActionListener(x);
    }
    public void listenerBatal (ActionListener x){
        jbBatal.addActionListener(x);
    }
    
    public void listenerEdit(ActionListener x) {
        jbEdit.addActionListener(x);
    }

    //UNTUK LOGOUT EXIT KEMBALI KE MASA LALU
    public void listenerExit(ActionListener x) {
        Jbexit.addActionListener(x);
    }
    
    public void listenerLogout(ActionListener x) {
        jbLogout.addActionListener(x);
    }
    
    public void listenerBack(ActionListener x) {
        jbBack.addActionListener(x);
    }
    
    public void notif(String x) {
        notif.setText(x);
    }

    //untuk tabel
    public int getRowTable() {
        int row = tabelKomik.getSelectedRow();
        return row;
    }
    
    public Object getTableValue(int a, int b) {
        Object value = tabelKomik.getValueAt(a, b);
        return value;
    }
    
    public void setKomikTable(DefaultTableModel model) {
        tabelKomik.setModel(model);
    }
    
    public void setPath(String x) {
        tfUpload.setText(x);
    }
    
    public String getPathFromTfUpload() {
        return tfUpload.getText();
    }
    
    public void listenerTableKomik(MouseListener x) {
        tabelKomik.addMouseListener(x);
    }

    //untuk upload gambar
    public void setGambar(String path) {
        File sourceImage = new File(path);
        BufferedImage image = null;
        try {
            image = ImageIO.read(sourceImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Image img = image.getScaledInstance(LsetGambar.getWidth(), LsetGambar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imgIcon = new ImageIcon(img);
        LsetGambar.setIcon(imgIcon);
    }
    
    public void resetView(Icon x) {
        LsetGambar.setIcon(x);
    }
    
    public void gambar() {
        File imageFile = null;
        jFileChooser1.setMultiSelectionEnabled(false);
        jFileChooser1.setDialogType(jFileChooser1.OPEN_DIALOG);
        jFileChooser1.setFileFilter(new FileNameExtensionFilter("JPG. JPEG, PNG", new String[]{"JPG", "JPEG", "PNG"}));
        jFileChooser1.setDialogTitle("Pilih Sampul Komik");
        if (jFileChooser1.showOpenDialog(imagePreview) == jFileChooser1.OPEN_DIALOG) {
            imageFile = jFileChooser1.getSelectedFile();
            ss.setFile(imageFile);
            tfUpload.setText(imageFile.getAbsolutePath());
            setGambar(imageFile.getAbsolutePath());
            ss.setPath(getPathFromTfUpload());
        }
        if (ss.getFile().length() > Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(rootPane, "file terlalu besar");
        }
    }
    
    public void listenerUpload(ActionListener x) {
        jbUpload.addActionListener(x);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        tfPengarang = new javax.swing.JTextField();
        tfJudul = new javax.swing.JTextField();
        tfChapter = new javax.swing.JTextField();
        jbSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKomik = new javax.swing.JTable();
        jkTerbit = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        tfIDkomik = new javax.swing.JTextField();
        tfGenre = new javax.swing.JComboBox<>();
        notif = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Jbexit = new javax.swing.JButton();
        jbUpload = new javax.swing.JButton();
        tfUpload = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        LsetGambar = new javax.swing.JLabel();
        jbLogout = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jbBatal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPengarangActionPerformed(evt);
            }
        });
        getContentPane().add(tfPengarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 220, -1));
        getContentPane().add(tfJudul, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 220, -1));
        getContentPane().add(tfChapter, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 220, -1));

        jbSimpan.setText("Tambah");
        getContentPane().add(jbSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, -1, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID Komik");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Judul");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Genre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Chapter");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Upload Gambar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        tabelKomik.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelKomik);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 510, 290));
        getContentPane().add(jkTerbit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 220, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Pengarang");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));
        getContentPane().add(tfIDkomik, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 220, -1));

        tfGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Action", "Romance", "Comedy", "Adventure", "Horror", "Drama" }));
        getContentPane().add(tfGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 220, -1));

        notif.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        notif.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(notif, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 250, 20));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("DAFTAR KOMIK");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, 20));

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("TAMBAH KOMIK");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        Jbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit putih.png"))); // NOI18N
        Jbexit.setBorderPainted(false);
        Jbexit.setContentAreaFilled(false);
        Jbexit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit hitam.png"))); // NOI18N
        getContentPane().add(Jbexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, -1, -1));

        jbUpload.setText("...");
        getContentPane().add(jbUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));
        getContentPane().add(tfUpload, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 170, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Terbit");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        LsetGambar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        LsetGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LsetGambar.setText("PREVIEW GAMBAR");
        LsetGambar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(LsetGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 130, 170));

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

        jbEdit.setText("Edit");
        getContentPane().add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 80, -1));

        jbBatal.setText("Batal");
        getContentPane().add(jbBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 80, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/home.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPengarangActionPerformed

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
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbexit;
    private javax.swing.JLabel LsetGambar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbBatal;
    private javax.swing.JButton jbEdit;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbSimpan;
    private javax.swing.JButton jbUpload;
    private com.toedter.calendar.JDateChooser jkTerbit;
    private javax.swing.JLabel notif;
    private javax.swing.JTable tabelKomik;
    private javax.swing.JTextField tfChapter;
    private javax.swing.JComboBox<String> tfGenre;
    private javax.swing.JTextField tfIDkomik;
    private javax.swing.JTextField tfJudul;
    private javax.swing.JTextField tfPengarang;
    private javax.swing.JTextField tfUpload;
    // End of variables declaration//GEN-END:variables
}
