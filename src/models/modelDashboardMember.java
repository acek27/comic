/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import comic.DashboardMember;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Acek
 */
public class modelDashboardMember {

    koneksi sambung;
    DashboardMember dm = new DashboardMember();

    public modelDashboardMember() {
        sambung = new koneksi();
    }

    public ImageIcon viewGambar(int status) {
        ImageIcon icon = null;
        try {
            PreparedStatement statement = sambung.getKoneksi().
                    prepareStatement("select gambar from db_komik where status = " + status + "");
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
//    public ImageIcon ambilGambar(String id) {
//        ImageIcon icon = null;
//        try {
//            PreparedStatement statement = sambung.getKoneksi().
//                    prepareStatement("select gambar from db_komik where id_komik='" + id + "'");
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                InputStream is = rs.getBlob("gambar").getBinaryStream();
//                icon = new ImageIcon(// fill this Image with ImageIO and read the stream
//                ImageIO.read(is));
//            }
//        } catch (Exception e) {
//        }
//        return icon;
//    }
}
