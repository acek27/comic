/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acek
 */
public class modelManajemenDashboard {
    koneksi sambung;
    public modelManajemenDashboard(){
        sambung = new koneksi();
    }
    
     public DefaultTableModel setListKomik() {
        String query = "SELECT id_komik, judul, chapter, status FROM `db_komik`";
        DefaultTableModel model = sambung.select(query);
        return model;
    }
     
      public void UpdateGambar(String id_komik, String status) {
        try {
            String query = "UPDATE db_komik set status = " + status +" where id_komik = '" + id_komik + "'";
            sambung.insertUpdateDelete(query);
            System.out.println(query);
        } catch (Exception e) {
        }
    }
      public void ResetGambar() {
        try {
            String query = "UPDATE db_komik set status = 0";
            sambung.insertUpdateDelete(query);
            System.out.println(query);
        } catch (Exception e) {
        }
    }
}
