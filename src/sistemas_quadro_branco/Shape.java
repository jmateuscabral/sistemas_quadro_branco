package sistemas_quadro_branco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Shape extends Remote{
	int getVersion() throws RemoteException;
	GraphicalObject getAllState() throws RemoteException;
}