/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Acek
 */
public class modelLogin {

    koneksi sambung;

    public modelLogin() {
        sambung = new koneksi();
    }

    public boolean checkLogIn(String username, String pass) {
        boolean akses = false;
        int idAkses = 0;
        String userlogin = username;
        String userpass = pass;
        boolean passed = false;
        try {
            String query = "SELECT `username`, `password` FROM `login` WHERE username = '" + userlogin
                    + "' and password = '" + userpass + "'";
            Statement stmt = sambung.getKoneksi().createStatement();
            ResultSet rs = stmt.executeQuery(query);
//            System.out.println(query);
            if (rs.next()) {
                passed = true;
            }
        } catch (Exception e) {
        }
        return passed;
    }

    public String getId(String username, String pass) {
        String id = null;
        String namaUser = username;
        String passUser = pass;
        try {
            String query = " select id_user from login where "
                    + "username = '" + namaUser + "' and password = '" + passUser + "'";
            System.out.println(query);
            Statement st = sambung.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                id = rs.getString("id_user");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }
}
