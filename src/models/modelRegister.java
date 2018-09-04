package models;

public class modelRegister {

    koneksi sambung;

    public modelRegister() {
        sambung = new koneksi();
    }

    public void addNewAccount(String username, String password, String no_KTP, String nama, String ttl, String jKlamin, String pekerjaan, String alamat) {
        String query
                = "INSERT INTO `login`"
                + "(`id_user`, "
                +"`username`, `"
                + "password`, "
                + "`no_ktp`, "
                + "`nama`, "
                + "`ttl`, "
                + "`jKelamin`, "
                + "`pekerjaan`, "
                + "`alamat`) "
                + "VALUES (NULL, "
                + "'" + username + "', "
                + "'" + password + "', "
                + "'" + no_KTP + "', "
                + "'" + nama + "', "
                + "'" + ttl + "', "
                + "'" + jKlamin + "', "
                + "'" + pekerjaan + "', "
                + "'" + alamat + "')";
        sambung.insertUpdateDelete(query);
        System.out.println(query);
    }
}
