/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager; //menghubungkan ke mysql
import java.sql.PreparedStatement; //untuk CRUD
import java.sql.Date;


/**
 *
 * @author ACER
 */
public class koneksi {
    private String database_name = "sisteminformasi_rawatinap";
    private String username = "root";
    private String password = "";
    public Connection koneksiDB; 
    
    public koneksi(){
    
        try {  
            String lokasi = "jdbc:mysql://localhost/" + database_name;
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(lokasi, username, password);
            
            //System.out.println("Database Terkoneksi");
        } catch (Exception e) {
            System.out.println(e.getMessage());          
        }
        
    }
    
    //Tabel Daftar Pasien
    public void SimpanDaftarPasien(int id_pasien, String nomor_rawat_inap, int id_identitas, String nama, Date tanggal_lahir, String jenis_kelamin, String kamar){
        try {
            String sql = "INSERT INTO daftar_pasien (id_pasien, nomor_rawat_inap, id_identitas, nama, tanggal_lahir, jenis_kelamin, kamar) VALUE (?,?,?,?,?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setInt(1, id_pasien);
            perintah.setString(2, nomor_rawat_inap);
            perintah.setInt(3, id_identitas);
            perintah.setString(4, nama);
            perintah.setDate(5, tanggal_lahir);
            perintah.setString(6, jenis_kelamin);
            perintah.setString(7, kamar);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void UbahDaftarPasien(int id_pasien, String nomor_rawat_inap, int id_identitas, String nama, Date tanggal_lahir, String jenis_kelamin, String kamar){
        try {
            String sql = "UPDATE daftar_pasien SET id_pasien=?, nomor_rawat_inap=?, id_identitas=?, nama=?, tanggal_lahir=?, jenis_kelamin=?, kamar=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setInt(1, id_pasien);
            perintah.setString(2, nomor_rawat_inap);
            perintah.setInt(3, id_identitas);
            perintah.setString(4, nama);
            perintah.setDate(5, tanggal_lahir);
            perintah.setString(6, jenis_kelamin);
            perintah.setString(7, kamar);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void HapusDaftarPasien(int id_pasien ){
        try {
            String sql = "DELETE FROM daftar_pasien where id_pasien=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_pasien);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    
   //Tabel Daftar Pegawai
    public void SimpanDaftarPegawai(int id_pegawai, String nama, String jenis_kelamin, String posisi){
        try {
            String sql = "INSERT INTO daftar_pegawai (id_pegawai, nama, jenis_kelamin, posisi) VALUE (?,?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setInt(1, id_pegawai);
            perintah.setString(2, nama);
            perintah.setString(3, jenis_kelamin);
            perintah.setString(4, posisi);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void UbahDaftarPegawai(int id_pegawai, String nama, String jenis_kelamin, String posisi){
        try {
            String sql = "UPDATE daftar_pegawai SET nama=?, jenis_kelamin=?, posisi=? WHERE id_pegawai=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, jenis_kelamin);
            perintah.setString(3, posisi);
            perintah.setInt(4, id_pegawai);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void HapusDaftarPegawai(int id_pegawai ){
        try {
            String sql = "DELETE FROM daftar_pegawai where id_pegawai=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_pegawai);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    
    //Tabel Daftar Perawat
    public void SimpanDaftarPerawat(int id_perawat, String nama, String jenis_kelamin){
        try {
            String sql = "INSERT INTO daftar_perawat (id_perawat, nama, jenis_kelamin) VALUE (?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setInt(1, id_perawat);
            perintah.setString(2, nama);
            perintah.setString(3, jenis_kelamin);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void UbahDaftarPerawat(int id_perawat, String nama, String jenis_kelamin){
        try {
            String sql = "UPDATE daftar_perawat SET nama=?, jenis_kelamin=? WHERE id_perawat=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, nama);
            perintah.setString(2, jenis_kelamin);
            perintah.setInt(3, id_perawat);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void HapusDaftarPerawat(int id_perawat ){
        try {
            String sql = "DELETE FROM daftar_perawat where id_perawat=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_perawat);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    
    //Tabel Daftar Kamar
    public void SimpanDaftarKamar(int id_kamar, String gedung, String ruang, String kamar, String kasur_tersedia){
        try {
            String sql = "INSERT INTO daftar_kamar (id_kamar, gedung, ruang, kamar, kasur_tersedia) VALUE (?,?,?,?,?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setInt(1, id_kamar);
            perintah.setString(2, gedung);
            perintah.setString(3, ruang);
            perintah.setString(4, kamar);
            perintah.setString(5, kasur_tersedia);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Disimpan");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void UbahDaftarKamar(int id_kamar, String gedung, String ruang, String kamar, String kasur_tersedia){
        try {
            String sql = "UPDATE daftar_kamar SET gedung=?, ruang=?, kamar=?, kasur_tersedia=? WHERE id_kamar=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            
            perintah.setString(1, gedung);
            perintah.setString(2, ruang);
            perintah.setString(3, kamar);
            perintah.setString(4, kasur_tersedia);
            perintah.setInt(5, id_kamar);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Diubah");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    public void HapusDaftarKamar(int id_kamar ){
        try {
            String sql = "DELETE FROM daftar_kamar where id_kamar=?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);

            perintah.setInt(1, id_kamar);
            
            perintah.executeUpdate();
            System.out.println("Berhasil Dihapus");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
