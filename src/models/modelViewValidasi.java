/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import comic.session;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class modelViewValidasi {
    koneksi sambung;
    public modelViewValidasi(){
        sambung = new koneksi();
    }
     public DefaultTableModel listBelum(String id) {
        String query = "SELECT dbp.id_peminjaman, dbl.nama, dbk.judul, dbp.tgl_peminjaman FROM db_peminjaman dbp join db_komik dbk on dbp.id_komik = "
                + "dbk.id_komik join login dbl on dbp.id_user = dbl.id_user where dbp.status = 1 and dbl.id_user = "+id;
        DefaultTableModel model = sambung.select(query);
        return model;
    }

    public DefaultTableModel listSudah(String id) {
        String query = "SELECT dbp.id_peminjaman, dbl.nama, dbk.judul, dbp.tgl_peminjaman FROM db_peminjaman dbp join db_komik dbk on dbp.id_komik = "
                + "dbk.id_komik join login dbl on dbp.id_user = dbl.id_user where dbp.status = 2 and dbl.id_user = "+id;
        DefaultTableModel model = sambung.select(query);
        return model;
    }
}
