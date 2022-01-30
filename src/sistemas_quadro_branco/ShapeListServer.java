package sistemas_quadro_branco;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.net.ssl.SNIHostName;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;

public class ShapeListServer {
	
	public static void main(String[] args){
		
		System.setProperty("java.rmi.server.hostname", "192.168.56.102");
		//System.setProperty("java.rmi.server.hostname","1.2.3.4"); 
		
        try{
        	        	
        	Registry rgsty = LocateRegistry.createRegistry(8080);
        	//Registry rgsty = LocateRegistry.getRegistry("10.0.2.255", 8080);

            ShapeList aShapelist = new ShapeListServant();
            String objName = "ShapeList";
            //String objName = "ShapeList";

            //System.out.println(LocateRegistry.getRegistry("192.168.56.101"));
                        
            rgsty.rebind(objName, aShapelist);

			System.out.println("ShapeList server ready");
			
        } catch(Exception e) {
            System.out.println("ERRO ShapeList server main \n" + e.getMessage());
        }
    }
}