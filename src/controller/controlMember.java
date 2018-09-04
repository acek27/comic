package controller;

import comic.DashboardMember;
import comic.HomeMember;
import comic.session;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelMember;

public class controlMember {

    HomeMember hm = new HomeMember();
    models.modelMember mm = new modelMember();
    session ss = new session();

    public controlMember() {
        hm.setVisible(true);
        setTableKomik();
        setTablePinjam();
        hm.listenerCari(new pencarian());
        hm.listenerExit(new exitButton());
        hm.listenerLogout(new LogoutButton());
        hm.listenerTabelKomik(new tabelKomik());
        hm.listenerBack(new BackButton());
        hm.listenerPilih(new TombolPilih());
        hm.listenerReset(new TombolReset());
        hm.listenerSelesai(new tombolSelesai());
    }

//    public void reload() {
//        controlAdmin ca = new controlAdmin();
//    }
    public void setTableKomik() {
        DefaultTableModel model = mm.setList();
        hm.setlist(model);
    }

    public void setTablePinjam() {
        DefaultTableModel model = mm.setPinjam();
        hm.setlistPinjam(model);
    }

    class pencarian implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String kat = hm.getKategori();
            String cari = hm.getCari();
            boolean checkCari = mm.checkCari(cari);
            if (cari.equals("")) {
                hm.setnotif("kolom tidak boleh kosong!");
            } else if (checkCari == false) {
                hm.setnotif("Pencarian tidak ditemukan");
                DefaultTableModel model = mm.cariKomik(kat, cari);
                hm.setlist(model);
                hm.resetText("");
            } else {
                DefaultTableModel model = mm.cariKomik(kat, cari);
                hm.setlist(model);
                hm.resetText("");
                hm.setnotif("");
            }
        }
    }

    class TombolPilih implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = hm.getRowTable();
            String id = (String) hm.getTableValue(row, 0);
            mm.pilihKomik(ss.get(), id);
            mm.updatePinjam(id);
            setTablePinjam();
            setTableKomik();
        }
    }

    class TombolReset implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = hm.getRowTable();
            mm.resetPilihan(ss.get());
            mm.resetPinjam();
            setTablePinjam();
            setTableKomik();
        }
    }

    class tombolSelesai implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboardMember cdm = new controlDashboardMember();
            hm.dispose();
        }

    }

    //untuk exit, logout dan kembali
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
            hm.dispose();
        }
    }

    class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboardMember cl = new controlDashboardMember();
            hm.dispose();
        }
    }

    //untuk mouse listener
    class tabelKomik implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int row = hm.getRowTable();
            String id = (String) hm.getTableValue(row, 0);
            ImageIcon icon = mm.viewGambar(id);
            hm.setImage(icon);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
