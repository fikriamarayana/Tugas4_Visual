/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas.pkg4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Tugas4 {
    public static Connection con;
    public static Statement stmt;
    public static ResultSet res;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String url ="jdbc:mysql://localhost:3306/wisata";
            String user="root";
            String pass="fikria";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =DriverManager.getConnection(url,user,pass);
            stmt = con.createStatement();
            String sql = "SELECT * FROM tempat_wisata";
            res = stmt.executeQuery(sql);
            
            while(res.next()){
                System.out.println("ID Tempat Wisata: " + res.getInt("id_tempat_wisata"));
                System.out.println("Nama Tempat Wisata: " + res.getString("nama_tempat_wisata"));
                System.out.println("Alamat: " + res.getString("alamat"));
                System.out.println("Nomor Telepon: " + res.getString("no_telepon"));
                System.out.println("Keterangan: " + res.getString("keterangan"));
            }
             stmt.close();
            con.close();
            System.out.println("koneksi berhasil;");
        } catch (Exception e) {
            System.err.println("koneksi gagal " +e.getMessage());
        }
    }
    
}
