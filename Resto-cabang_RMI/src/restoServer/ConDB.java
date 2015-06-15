/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoServer;

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

    public ResultSet query(String tanggal) throws SQLException {
        //    QUERY UNTUK MENGAMBIL NILAI TRANSAKSI BERDASARKAN TANGGAL
        String sql = "SELECT * FROM transaksi WHERE tanggal = '" + tanggal + "'";
        return this.stm.executeQuery(sql);
    }
    
    public ResultSet queryAll() throws SQLException {
        //    QUERY UNTUK MENGAMBIL NILAI TRANSAKSI BERDASARKAN TANGGAL
        String sql = "SELECT * FROM transaksi WHERE tanggal = 1";
        return this.stm.executeQuery(sql);
    }
    
    public ResultSet querySin() throws SQLException {
        //    QUERY UNTUK MENGAMBIL NILAI TRANSAKSI BERDASARKAN TANGGAL
        String sql = "SELECT * FROM transaksi WHERE statusSin = 0";
        
        return this.stm.executeQuery(sql);
    }
    
    public void updateSin(){
        String sql = "UPDATE transaksi SET statusSin = 1 WHERE statusSin = 0";
        try {
            this.stm.executeUpdate(sql);
            System.out.println("berhasil diupdate");
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getTransToTable() {
//        STRING HASIL YANG DIKEMBALIKAN
        String trans = "";
        try {
//            MENDAPATKAN NILAI TRANSAKSI
            ResultSet rs = this.queryAll();
            while (rs.next()) {
                trans += rs.getInt(1) + "<" + rs.getString(3) + "<" + rs.getInt(4) + "<" + rs.getInt(5) + "<" + rs.getString(6) + "<<";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trans;
    }

    public String getTrans(String tanggal) {
//        STRING HASIL YANG DIKEMBALIKAN
        String trans = "";
        try {
//            MENDAPATKAN NILAI TRANSAKSI
            ResultSet rs = this.query(tanggal);
            while (rs.next()) {
                trans += rs.getInt(1) + "<" + rs.getString(2) + "<" + rs.getInt(3) + "<" + rs.getInt(4) + "<" + rs.getString(5) + "<<";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trans;
    }

    public String getSin() {
        String sinkronisasi = "";
        
        Cabang cb = new Cabang();
        String ip = cb.getIp();
        try {
//            MENDAPATKAN SINKRONISASI NILAI TRANSAKSI
            ResultSet rs = this.querySin();
            while (rs.next()) {
//                MENAMBAHKAN HASIL KE DALAM STRING TRANS
//                trans += "Id : " + rs.getInt(1) + "\n"
//                        + "Barang : " + rs.getString(2) + "\n"
//                        + "Jumlah : " + rs.getInt(3) + "\n"
//                        + "Harga : " + rs.getInt(4) + "\n"
//                        + "Tanggal : " + rs.getString(5) + "\n\n";
                sinkronisasi += rs.getInt(1) + "<" + rs.getString(2) + "<" + rs.getInt(3) + "<" + rs.getInt(4) + "<" + rs.getString(5) + "<" + ip + "<<";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        updateSin();
        return sinkronisasi;
    }

    public String inputTrans(String b, int j, int h, String t) {

        String status = "";

        String sql = "INSERT INTO transaksi VALUES(NULL,'" + b + "'," + j + "," + h + ",'" + t + "',0)";
        try {
            this.stm.executeUpdate(sql);
            status = "Data Berhasil dimasukan";
        } catch (SQLException ex) {
            Logger.getLogger(ConDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
}
