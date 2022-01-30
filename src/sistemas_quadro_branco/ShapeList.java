package sistemas_quadro_branco;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface ShapeList extends Remote {
	Shape newShape(GraphicalObject g) throws RemoteException; 
	Vector allShapes()throws RemoteException;
	int getVersion() throws RemoteException;

}