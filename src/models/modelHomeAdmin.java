/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class modelHomeAdmin {

    koneksi sambung;

    public modelHomeAdmin() {
        sambung = new koneksi();
    }

    public void addBook(String id_komik, String pengarang, String judul, String genre, int chapter, String terbit, File Imagefile) {
        try {
            InputStream fis = new FileInputStream(Imagefile);
            PreparedStatement query = sambung.getKoneksi().prepareStatement("INSERT INTO `db_komik`"
                    + "(`id_komik`, "
                    + "`judul`, "
                    + "`pengarang`, "
                    + "`genre`, "
                    + "`tgl_terbit`, "
                    + "`chapter`, `gambar`, `status`, `status_pinjam`) "
                    + "VALUES ( "
                    + "'" + id_komik + "', "
                    + "'" + judul + "', "
                    + "'" + pengarang + "', "
                    + "'" + genre + "', "
                    + "'" + terbit + "', "
                    + "'" + chapter + "', ?, 0, 0)");
            query.setBlob(1, fis);
            query.executeUpdate();
            Component parentComponent = null;
//            System.out.println(query);
//            sambung.insertUpdateDelete(query);
            JOptionPane.showMessageDialog(parentComponent, "sukses");
        } catch (Exception e) {
            Component pane = null;
            JOptionPane.showMessageDialog(pane, "gagal" + e.getMessage());
        }

    }

    public void UpdateBook(String id_komik, String pengarang, String judul, String genre, int chapter, String terbit) {
        try {
            String query = "UPDATE db_komik set judul = '" + judul + "', pengarang ='" + pengarang + "', "
                    + "genre ='" + genre + "', tgl_terbit = '" + terbit + "', chapter = " + chapter + " where id_komik = '" + id_komik + "'";
            sambung.insertUpdateDelete(query);
            System.out.println(query);
        } catch (Exception e) {
        }
    }

    //untuk tabel
    public DefaultTableModel setListKomik() {
        String query = "SELECT id_komik, judul, pengarang, genre, tgl_terbit, chapter FROM `db_komik`";
        DefaultTableModel model = sambung.select(query);
        return model;
    }
}
