/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugaspbo2;
import crud.koneksi;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ACER
 */
public class Tugaspbo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        koneksi myObject = new koneksi();
         
         SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date utilDate = null;
    try {
        utilDate = format.parse("12/06/2024");
    } catch (ParseException e) {
        e.printStackTrace();
    }

    Date sqlDate = new Date(utilDate.getTime());
         
    myObject.SimpanDaftarPerawat(3, "Riyo", "Laki-Laki");
    
     //sqlDate new Date(new java.util.Date().getTime()); 
        //myObject.UbahDaftarPegawai(3, "Dina", "Perempuan", "Perawat");
         
    }
    
}
