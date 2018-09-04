/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic;

import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class Validasi extends javax.swing.JFrame {

    /**
     * Creates new form Validasi
     */
    public Validasi() {
        initComponents();
    }
    
    public int getRowTable() {
        int row = tBelumValid.getSelectedRow();
        return row;
    }

    public Object getTableValue(int a, int b) {
        Object value = tBelumValid.getValueAt(a, b);
        return value;
    }

    public void setbelum(DefaultTableModel model) {
        tBelumValid.setModel(model);
    }

    public int getRowTableSudah() {
        int row = tSudahValid.getSelectedRow();
        return row;
    }

    public Object getTableValueSudah(int a, int b) {
        Object value = tSudahValid.getValueAt(a, b);
        return value;
    }

    public void setSudah(DefaultTableModel model) {
        tSudahValid.setModel(model);
    }
    
  public void listenerValidasi(ActionListener e){
      jbValidasi.addActionListener(e);
  }

  public void listenerExit(ActionListener x) {
        Jbexit.addActionListener(x);
    }
    
    public void listenerLogout(ActionListener x) {
        jbLogout.addActionListener(x);
    }
    
    public void listenerBack(ActionListener x) {
        jbBack.addActionListener(x);
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
        tBelumValid = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tSudahValid = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbValidasi = new javax.swing.JButton();
        jbBack = new javax.swing.JButton();
        jbLogout = new javax.swing.JButton();
        Jbexit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tBelumValid.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tBelumValid);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 410, 290));

        tSudahValid.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tSudahValid);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 420, 290));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel4.setText("VALIDASI KOMIK");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel1.setText("Telah diValidasi");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, -1));

        jLabel2.setText("Belum divalidasi");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jbValidasi.setText("Validasi Sekarang");
        getContentPane().add(jbValidasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, -1, -1));

        jbBack.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbBack.setForeground(new java.awt.Color(255, 255, 255));
        jbBack.setText("Kembali");
        jbBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jbBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, 30));

        jbLogout.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jbLogout.setForeground(new java.awt.Color(255, 255, 255));
        jbLogout.setText("Log out");
        jbLogout.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jbLogout.setBorderPainted(false);
        jbLogout.setContentAreaFilled(false);
        jbLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, -1, 30));

        Jbexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit putih.png"))); // NOI18N
        Jbexit.setBorderPainted(false);
        Jbexit.setContentAreaFilled(false);
        Jbexit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/loginAndReg/exit hitam.png"))); // NOI18N
        getContentPane().add(Jbexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/member/1.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Validasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Validasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Validasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Validasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Validasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbexit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBack;
    private javax.swing.JButton jbLogout;
    private javax.swing.JButton jbValidasi;
    private javax.swing.JTable tBelumValid;
    private javax.swing.JTable tSudahValid;
    // End of variables declaration//GEN-END:variables
}
