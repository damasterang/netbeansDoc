/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Zero
 */
public interface InterfaceResto extends Remote{
    
    public String cekTransaksi(String tanggal, int publicKey) throws RemoteException;
    
    public String sinkronisasi() throws RemoteException;
    
//    private int 
    
}
