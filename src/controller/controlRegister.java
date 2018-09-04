package controller;

import comic.login;
import comic.register;
import java.awt.Component;
import models.modelRegister;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class controlRegister {

    login lv = new login();
    modelRegister mr = new modelRegister();
    register reg = new register();

    public controlRegister() {
        reg.setVisible(true);
        reg.listenerRegister(new registration());
        reg.listenerExit(new exitButton());
        reg.listenerLogin(new loginButton());
    }

    class registration implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (reg.getUsername().equals("") || reg.getPassword().equals("") || reg.getTfKTP().equals("") || reg.getTfNama().equals("") || reg.gettanggal().equals("") || reg.getJenis().equals("") || reg.getPekerjaan().equals("") || reg.getAlamat().equals("")) {
                reg.notif("Semua data harus diisi");
            } else {
                mr.addNewAccount(reg.getUsername(), reg.getPassword(), reg.getTfKTP(), reg.getTfNama(), reg.gettanggal(), reg.getJenis(), reg.getPekerjaan(), reg.getAlamat());
                reg.dispose();
                controlLogin log = new controlLogin();
            }
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

    class loginButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            lv.setVisible(true);
            reg.dispose();
            konekKontroller();
        }
    }

    public void konekKontroller() {
        lv.dispose();
        controlLogin log = new controlLogin();
    }

}
