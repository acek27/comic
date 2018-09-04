/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comic.session;
import comic.viewValidasi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelViewValidasi;

/**
 *
 * @author Acek
 */
public class controlViewValidasi {
    viewValidasi vvl = new viewValidasi();
    modelViewValidasi mvvl = new modelViewValidasi();
    session ss = new session();
    public controlViewValidasi() {
        vvl.setVisible(true);
    setTabelSudah();
    setTableBelum();
    vvl.listenerBack(new BackButton());
    vvl.listenerExit(new exitButton());
    vvl.listenerLogout(new LogoutButton());
    }
      public void setTableBelum() {
        DefaultTableModel model = mvvl.listBelum(ss.get());
        vvl.setbelum(model);
    }
     public void setTabelSudah() {
        DefaultTableModel model = mvvl.listSudah(ss.get());
        vvl.setSudah(model);
    }
      class exitButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Component RootPane = null;
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
            vvl.dispose();
        }
    }

    class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboardMember cl = new controlDashboardMember();
            vvl.dispose();
        }
    }
}
