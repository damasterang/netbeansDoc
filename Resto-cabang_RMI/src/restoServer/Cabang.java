/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Zero
 */
public class Cabang {
    
    public String ip = "127.0.0.1";

    public Cabang() {
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        int i = 1;
        
//        MEMBUAT REGISTRY PADA SERVER
        Registry registry = LocateRegistry.createRegistry(1010);
        ImplementsResto ir = new ImplementsResto(i);
        registry.rebind("resto", ir);
        System.out.println("Cabang Resto OK");
        i++;
        
        CabangForm cf = new CabangForm();
        cf.setVisible(true);
        
    }
    
    public String getIp(){
        return this.ip;
    }
    
}
