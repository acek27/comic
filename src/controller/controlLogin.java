
package controller;

import comic.login;
import comic.register;
import comic.session;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.RootPaneContainer;
import models.modelLogin;

public class controlLogin {

    login lv = new login();
    register reg = new register();
    modelLogin ml = new modelLogin();

    byte count = 0;

    public controlLogin() {
        lv.setVisible(true);
        lv.listenerLogIn(new signButton());
        lv.listenerExit(new exitButton());
        lv.listenerRegister(new registerButton());
    }

    class signButton implements ActionListener {

        String idLog = null;

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (lv.getUserName().toLowerCase().equals("admin") && lv.getUserPass().toLowerCase().equals("admin")) {
                System.out.println("sukses");
                controlDashboarAdmin cda = new controlDashboarAdmin();
                lv.dispose();
            } else {
                boolean check = ml.checkLogIn(lv.getUserName(), lv.getUserPass());
                if (check == true) {
                    //panggil control HomeView
                    idLog = ml.getId(lv.getUserName(), lv.getUserPass());
                    session ss = new session();
                    ss.set(idLog);
                    System.out.println(idLog);
                    lv.dispose();
                    controlDashboardMember da = new controlDashboardMember();
                } else if (check == false) {
                    if (count < 2) {
                        lv.setUserName("");
                        lv.setUserPass("");
                        lv.setNotif("Username dan Password Salah!");
                        count++;
                    } else {
                        System.exit(0);
                    }
                }
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

    class registerButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            reg.setVisible(true);
            lv.dispose();
            konekKontroller();
        }
    }

    public void konekKontroller() {
        reg.dispose();
        controlRegister cr = new controlRegister();
    }

}
