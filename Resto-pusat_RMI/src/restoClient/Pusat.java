/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import resto.InterfaceResto;

/**
 *
 * @author Zero
 */
public class Pusat {
    
    static String dataInput;
    InterfaceResto ir;
    
    static String input(){
        BufferedReader masukan = new BufferedReader(new InputStreamReader(System.in));
        try {
            dataInput = masukan.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return dataInput;
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException{
        
        PusatForm cf = new PusatForm();
        cf.setVisible(true);
        
    }
    
//    public String cekTransaksi(String tanggal) throws RemoteException, NotBoundException, MalformedURLException{
//        
////        RESPON DARI PENGIRIM
//        String respon;
//        
//        Schmidt_Samoa satpam = new Schmidt_Samoa();
//        
//        String chiperTextTanggal = satpam.encrypt(tanggal);
//        System.out.println("Pusat Mengumpan " + chiperTextTanggal);
//        
//        String trans = this.ir.cekTransaksi(chiperTextTanggal, satpam.getPublicKey());
//        System.out.println("Pusat Menangkap " + trans);
//        String plainText = satpam.decrypt(trans);
//        
////        RESPON DITERIMA DENGAN MENGUMPAN PAR TANGGAL KE METHOD PRINT
////        respon = this.ir.cekTransaksi(tanggal);
//        respon = plainText;
//        
//        return(respon);
//    }
    
    public String getSinkronisasi() throws RemoteException{
        
        String sinkronisasi = this.ir.sinkronisasi();
        
        return sinkronisasi;
    }

    public Pusat(String target) throws RemoteException, MalformedURLException, NotBoundException {
        
//        MENYAMBUNGKAN DENGAN INTERFACERESTO AGAR DIBIND DENGAN LOCALHOST PORT 1099 DENGAN NAMA RESTO
//        ir = (InterfaceResto) Naming.lookup("rmi://localhost:1099/resto");
        ir = (InterfaceResto) Naming.lookup("rmi://"+target);
        
        System.out.println("Pusat Terhubung dengan " + target);
        
    }
    
    public String cekSinkronisasi(){
        String result = "";
        
        return result;
    }
    
}
