/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comic.DashboardAdmin;
import comic.Validasi;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.modelDashboardAdmin;

/**
 *
 * @author Acek
 */
public class controlDashboarAdmin {

    DashboardAdmin da = new DashboardAdmin();
    modelDashboardAdmin mda = new modelDashboardAdmin();

    public controlDashboarAdmin() {
        da.setVisible(true);
        da.setToolTips("Manajemen Komik");
        da.setToolTipsValidasi("Validasi Peminjaman");
        da.setToolTipsManDashboard("Mengatur Cover Komik di Halaman Dashboard");
        da.listenerTombolTambah(new tombolTambah());
        da.listenerExit(new exitButton());
        da.listenerLogout(new LogoutButton());
        da.listenerManajemen(new tombolManajemen());
        da.listenerValidasi(new tombolValid());
    }

    class tombolTambah implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlAdmin ca = new controlAdmin();
            da.dispose();
        }
    }

    class tombolManajemen implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlManajemenDashboard cmd = new controlManajemenDashboard();
            da.dispose();
        }
    }

    class tombolValid implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlValidasi cv = new controlValidasi();
            da.dispose();
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
            da.dispose();
        }
    }
}
