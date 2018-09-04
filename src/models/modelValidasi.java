/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import comic.Validasi;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class modelValidasi {

    koneksi sambung;

    public modelValidasi() {
        sambung = new koneksi();
    }

    public DefaultTableModel listBelum() {
        String query = "SELECT dbp.id_peminjaman, dbl.nama, dbk.judul, dbp.tgl_peminjaman FROM db_peminjaman dbp join db_komik dbk on dbp.id_komik = "
                + "dbk.id_komik join login dbl on dbp.id_user = dbl.id_user where dbp.status = 1";
        DefaultTableModel model = sambung.select(query);
        return model;
    }

    public DefaultTableModel listSudah() {
        String query = "SELECT dbp.id_peminjaman, dbl.nama, dbk.judul, dbp.tgl_peminjaman FROM db_peminjaman dbp join db_komik dbk on dbp.id_komik = "
                + "dbk.id_komik join login dbl on dbp.id_user = dbl.id_user where dbp.status = 2";
        DefaultTableModel model = sambung.select(query);
        return model;
    }

    public void validasi(int ID) {
        try {
            String query = "UPDATE `db_peminjaman` SET status = 2 where id_peminjaman = "+ID;
            sambung.insertUpdateDelete(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
