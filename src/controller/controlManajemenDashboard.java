/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import comic.ManajemenDashboard;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelManajemenDashboard;

/**
 *
 * @author Acek
 */
public class controlManajemenDashboard {
    modelManajemenDashboard mmd = new modelManajemenDashboard();
    ManajemenDashboard md = new ManajemenDashboard();
    public controlManajemenDashboard(){
        md.setVisible(true);
        md.enableTomol1(true);
        setTableKomik();
        md.listenerGambar1(new gambar1());
        md.listenerGambar2(new gambar2());
        md.listenerGambar3(new gambar3());
        md.listenerGambar4(new gambar4());
        md.listenerGambar5(new gambar5());
        md.listenerGambar6(new gambar6());
        md.listenerReset(new ResetGambar());
        md.listenerExit(new exitButton());
        md.listenerBack(new BackButton());
        md.listenerLogout(new LogoutButton());
    }
        public void reload() {
        setTableKomik();
    }
    public void setTableKomik() {
        DefaultTableModel model = mmd.setListKomik();
        md.setKomikTable(model);
    }
    class gambar1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "1");
        md.enableTomol1(false);
        reload();
        }
    }
    class gambar2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "2");
        md.enableTomol2(false);
        reload();
        }
    }
    
    class gambar3 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "3");
        md.enableTomol3(false);
        reload();
        }
    }
    
    class gambar4 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "4");
        md.enableTomol4(false);
        reload();
        }
    }
    class gambar5 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "5");
        md.enableTomol5(false);
        reload();
        }
    }
    
    class gambar6 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        String id = (String) md.getTableValue(row, 0);
        mmd.UpdateGambar(id, "6");
        md.enableTomol6(false);
        reload();
        }
    }
    class ResetGambar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        int row = md.getRowTable();
        mmd.ResetGambar();
        md.enableTomol1(true);
        md.enableTomol2(true);
        md.enableTomol3(true);
        md.enableTomol4(true);
        md.enableTomol5(true);
        md.enableTomol6(true);
        reload();
        }
    }
    //untuk exit
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
            md.dispose();
        }
    }

    class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboarAdmin cda = new controlDashboarAdmin();
            md.dispose();
        }
    }
}
