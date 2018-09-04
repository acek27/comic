/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comic.Validasi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelValidasi;

/**
 *
 * @author Acek
 */
public class controlValidasi {
    Validasi vv = new Validasi();
    modelValidasi mv = new modelValidasi();
    public controlValidasi(){
        vv.setVisible(true);
        setTableBelum();
        setTabelSudah();
        vv.listenerValidasi(new tombolValidasi());
        vv.listenerExit(new exitButton());
        vv.listenerLogout(new LogoutButton());
        vv.listenerBack(new BackButton());
    }
     public void setTableBelum() {
        DefaultTableModel model = mv.listBelum();
        vv.setbelum(model);
    }
     public void setTabelSudah() {
        DefaultTableModel model = mv.listSudah();
        vv.setSudah(model);
    }
     
     class tombolValidasi implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
         int row = vv.getRowTable();
         String id = (String) vv.getTableValue(row, 0);
         int nilaiID = Integer.parseInt(id);
         mv.validasi(nilaiID);
         setTableBelum();
         setTabelSudah();
        }
     }
     class exitButton implements ActionListener {

        private Component RootPane;

        @Override
        public void actionPerformed(ActionEvent e) {
            int a = JOptionPane.showConfirmDialog(RootPane, "Clik Yes to exit", "Message", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (a == 0) {
                System.exit(0);
            }
        }
    }

    class LogoutButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlLogin cl = new controlLogin();
            vv.dispose();
        }
    }

    class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboarAdmin cda = new controlDashboarAdmin();
            vv.dispose();
        }
    }
}
