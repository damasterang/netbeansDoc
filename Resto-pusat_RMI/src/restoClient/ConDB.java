/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoClient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero
 */
public class ConDB {

    private Connection con = null;
    private Statement stm = null;

//    KONEKSI KE DATABASE (MYSQL YANG DIGUNAKAN) YANG DIBENTUK SERVER
    public ConDB(String server, String db, String user, String pswd) {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String data = "jdbc:mysql://" + server + ":3306/" + db;
            con = DriverManager.getConnection(data, user, pswd);
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String tanggal, String target) throws SQLException {
        //    QUERY UNTUK MENGAMBIL NILAI TRANSAKSI BERDASARKAN TANGGAL
        String sql = "SELECT * FROM transaksi WHERE tanggal = '" + tanggal + "' AND client = '" + target + "'";
        return this.stm.executeQuery(sql);
    }
    
    public String getTrans(String tanggal, String target) {
//        STRING HASIL YANG DIKEMBALIKAN
        String trans = "";
        try {
//            MENDAPATKAN NILAI TRANSAKSI
            ResultSet rs = this.query(tanggal, target);
            while (rs.next()) {
                trans += rs.getInt(1) + "<" + rs.getString(3) + "<" + rs.getInt(4) + "<" + rs.getInt(5) + "<" + rs.getString(6) + "<<";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trans;
    }

    public void setSinkronisasi(int id, String barang, int jumlah, int harga, String tanggal, String ip) {

        String status = "";

        String sql = "INSERT INTO transaksi VALUES(NULL,'" + id + "','" + barang + "'," + jumlah + "," + harga + ",'" + tanggal + "','" + ip + "')";
        try {
            this.stm.executeUpdate(sql);
//            status = "Data Berhasil dimasukan";
            System.out.println("Data Berhasil dimasukan");
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }

//        return status;
    }
}
