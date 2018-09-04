/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comic.DashboardMember;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import models.modelDashboardMember;

/**
 *
 * @author Acek
 */
public class controlDashboardMember {

    DashboardMember dm = new DashboardMember();
    modelDashboardMember mdm = new modelDashboardMember();

    public controlDashboardMember() {
        dm.setVisible(true);
        dm.listenerPeminjaman(new buttonPeminjaman());
        showGambar(1);
        showGambar1(2);
        showGambar2(3);
        showGambar3(4);
        showGambar4(5);
        showGambar5(6);
        dm.listenerExit(new exitButton());
        dm.listenerLogout(new LogoutButton());
        dm.listenerViewValidasi(new buttonViewValidasi());
        dm.setTooltipsPeminjaman("Klik untuk meminjamkan buku");
        dm.setTooltipsStatus("Klik untuk melihat validasi peminjaman");
    }
    

    public void showGambar(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage(icon);
    }

    public void showGambar1(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage1(icon);
    }

    public void showGambar2(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage2(icon);
    }

    public void showGambar3(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage3(icon);
    }

    public void showGambar4(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage4(icon);
    }

    public void showGambar5(int status) {
        ImageIcon icon = mdm.viewGambar(status);
        dm.setImage5(icon);
    }

    class buttonPeminjaman implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlMember cm = new controlMember();
            dm.dispose();
        }
    }
    class buttonViewValidasi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlViewValidasi cvv = new controlViewValidasi();
            dm.dispose();
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
            dm.dispose();
        }
    }
}
