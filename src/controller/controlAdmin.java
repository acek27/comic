package controller;

import comic.HomeAdmin;
import comic.login;
import comic.register;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.modelHomeAdmin;
import GalbertoTuwondila.Source.Image.ImagePreview;
import comic.session;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class controlAdmin {

    HomeAdmin ha = new HomeAdmin();
    modelHomeAdmin mha = new modelHomeAdmin();
    ImagePreview imagePreview = new ImagePreview();

    session ss = new session();

    public controlAdmin() {
        ha.setVisible(true);
        ha.listenerSimpan(new tambahKomik());
        ha.listenerExit(new exitButton());
        ha.listenerLogout(new LogoutButton());
        ha.listenerBack(new BackButton());
        ha.listenerUpload(new uploadGambar());
        setTableKomik();
        ha.listenerEdit(new EditKomik());

        //mouse listener
        ha.listenerTableKomik(new tabelKomik());
//set enable tombol
        ha.setEditEnable(false);
        ha.listenerBatal(new tombolBatal());
    }

    //untuk tabel
    public void reload() {
        setTableKomik();
        ha.reloadAllInputs("");
        ha.resetView(null);
    }

    public void setTableKomik() {
        DefaultTableModel model = mha.setListKomik();
        ha.setKomikTable(model);
    }

    class tombolBatal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ha.reloadAllInputs("");
            ha.setEditEnable(false);
            ha.setSimpanEnable(true);
        }

    }

    class tambahKomik implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ha.getID().equals("") || ha.getPengarang().equals("") || ha.getJudul().equals("") || ha.getIsiChapter().equals("") || ha.getTerbit().equals("") || ha.getGenre().equals("")) {
                ha.notif("Semua data harus diisi");
                
            } else {
                int row = ha.getRowTable();
                mha.addBook(ha.getID(), ha.getPengarang(), ha.getJudul(), ha.getGenre(), ha.getChapter(), ha.getTerbit(), ss.getFile());
                reload();
                ha.setEditEnable(false);
            }
        }
    }

    class EditKomik implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ha.getID().equals("") || ha.getPengarang().equals("") || ha.getJudul().equals("") || ha.getIsiChapter().equals("") || ha.getTerbit().equals("") || ha.getGenre().equals("")) {
                ha.notif("Semua data harus diisi");
            } else {
                int row = ha.getRowTable();
                mha.UpdateBook(ha.getID(), ha.getPengarang(), ha.getJudul(), ha.getGenre(), ha.getChapter(), ha.getTerbit());
                reload();
            }
        }
    }

    class uploadGambar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ha.gambar();
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
            ha.dispose();
        }
    }

    class BackButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            controlDashboarAdmin cda = new controlDashboarAdmin();
            ha.dispose();
        }
    }

    //untuk mouse listener tabel
    class tabelKomik implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            int row = ha.getRowTable();
            String id = (String) ha.getTableValue(row, 0);
            ha.setID(id);
            String judul = (String) ha.getTableValue(row, 1);
            ha.setJudul(judul);
            String pengarang = (String) ha.getTableValue(row, 2);
            ha.setPengarang(pengarang);
            String genre = (String) ha.getTableValue(row, 3);
            ha.setGenre(genre);
            String chapter = (String) ha.getTableValue(row, 5);
            ha.setChapter(chapter);
            DateFormat format = new SimpleDateFormat("yyyy-M-d");
            String date = (String) ha.getTableValue(row, 4);
            try {
                ha.setDate((Date) format.parse(date));
            } catch (ParseException ex) {
                Logger.getLogger(controlAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            ha.setEditEnable(true);
            ha.setSimpanEnable(false);
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
