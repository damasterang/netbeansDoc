/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import resto.InterfaceResto;

/**
 *
 * @author Zero
 */
public class ImplementsResto extends UnicastRemoteObject implements InterfaceResto{
    
//    DISINI IMPLEMENTASI DARI INTERFACERESTO
    
    int nama;
    
        
//  KONEKSI YANG DIBUAT SERVER
    public ConDB test;

    public ImplementsResto(int nama) throws RemoteException{
        this.nama = nama;
        test = new ConDB("localhost", "resto_cabang", "root", "");
    }
    
    public int getNamaClient(){
        return this.nama;
    }
    
    public String cekTransaksi(String tanggal, int publicKey){
        
        Schmidt_Samoa satpam = new Schmidt_Samoa();
        satpam.generatePrivateKey(publicKey);
        String plainTextTanggal = satpam.decrypt(tanggal);
        
        System.out.println("Cabang Menangkap " + tanggal);
        
        
        String trans = test.getTrans(plainTextTanggal);
        String chiperText = satpam.encrypt(trans);
        
        System.out.println("Cabang Mengumpan " + chiperText);
        
//        GET TRANSAKSI BERDASARKAN TANGGAL
        return chiperText;
    }
    
    public String sinkronisasi(){
        
//        String result = "";
        
        String textSin = test.getSin();
        
        
        
        Schmidt_Samoa satpam = new Schmidt_Samoa();        
        String encrypted = satpam.encrypt(textSin);
        
        System.out.println(encrypted);
        
        String chiper = satpam.getP()+"<<<"+satpam.getQ()+"<<<"+encrypted;
        System.out.println(chiper);
        
        return chiper;
    }
    
}
