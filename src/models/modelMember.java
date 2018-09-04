/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import comic.session;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class modelMember {

    koneksi sambung;

    public modelMember() {
        sambung = new koneksi();
    }

    public DefaultTableModel setList() {
        String query = "SELECT id_komik, judul, pengarang, genre, chapter, tgl_terbit FROM db_komik where status_pinjam = 0";
        DefaultTableModel model = sambung.select(query);
//        System.out.println(query);
        return model;
    }

    public DefaultTableModel setPinjam() {
        session ss = new session();
        String query = "select judul, pengarang, genre, chapter from db_komik dbk "
                + "join db_peminjaman dbp on dbk.id_komik = dbp.id_komik where id_user = " + ss.get();
        DefaultTableModel model = sambung.select(query);
//        System.out.println(query);
        return model;
    }

    public DefaultTableModel cariKomik(String kategori, String cari) {
        String query = "SELECT id_komik, judul, pengarang, genre, chapter, tgl_terbit FROM `db_komik` where " + kategori + " like '%" + cari + "%';";
        DefaultTableModel model = sambung.select(query);
        return model;
    }

    public boolean checkCari(String cekCari) {
        boolean passed = false;
        try {
            String query = "SELECT * FROM `db_komik` "
                    + "WHERE judul like '%" + cekCari + "%' or "
                    + "genre like '%" + cekCari + "%' or "
                    + "pengarang like '%" + cekCari + "%' ";
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

    //untuk gambar
    public ImageIcon viewGambar(String id) {
        ImageIcon icon = null;
        try {
            PreparedStatement statement = sambung.getKoneksi().
                    prepareStatement("select gambar from db_komik where id_komik='" + id + "'");
            // hasil query
            ResultSet resultSet = statement.executeQuery();
            // jika return row > 0 or it has next
            while (resultSet.next()) {
                // get the stream
                InputStream is = resultSet.getBlob("gambar").getBinaryStream();
                try {
                    // create new icon
                    icon = new ImageIcon(// fill this Image with ImageIO and read the stream
                            ImageIO.read(is));
                    // show the image and tara!
//                    dm.setImage(icon);
                } catch (IOException e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return icon;
    }

    public void pilihKomik(String id_user, String id_komik) {
        String query = "INSERT INTO `db_peminjaman`(`id_peminjaman`, `tgl_peminjaman`, `id_user`, `tgl_kembali`, `id_komik`, `status`) "
                + "VALUES (null, current_date, " + id_user + ", null, '" + id_komik + "', '1')";
        sambung.insertUpdateDelete(query);
    }
    public void resetPilihan(String id_user){
        try {
         String query = "DELETE FROM `db_peminjaman` WHERE id_user = "+id_user;
        sambung.insertUpdateDelete(query);
        System.out.println(query);    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void resetPinjam(){
        try {
              String query = "UPDATE `db_komik` SET status_pinjam = 0";
         sambung.insertUpdateDelete(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void updatePinjam (String id_komik){
        String query = "UPDATE `db_komik` SET status_pinjam = 1 where id_komik = '"+id_komik+"'";
         sambung.insertUpdateDelete(query);
    }
}
