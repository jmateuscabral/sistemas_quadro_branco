package sistemas_quadro_branco;

import java.awt.Color;
import java.awt.Rectangle;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

public class ShapeListClient {
	
	public static void main(String args[]) {
		
		String option = "Read";
		String shapeType = "Rectangle";
		if (args.length > 0) option = args[0];
		if (args.length > 1) option = args[1];
		
		System.out.println(
				"Option:" + option +"\nShape:" + shapeType);
		
		try {

			ShapeList aShapeList  = (ShapeList) Naming.lookup("//localhost:8080/ShapeList");
			
 			System.out.println("Found server");
 			Vector sList = aShapeList.allShapes();
 			
 			System.out.println("Got vector");
 			
 			System.out.println(aShapeList.getVersion());
			
 			if(option.equals("Read")) {
 				 				
				for(int i=0; i<sList.size(); i++) {
										
        			GraphicalObject g = ((Shape)sList.elementAt(i)).getAllState();
        			
        			
        		}
				
        	} else {
        		
                GraphicalObject g = new GraphicalObject(shapeType, new Rectangle(50,50,300,400),Color.red,
                  			Color.blue, false);

                System.out.println("Created graphical object");
      					aShapeList.newShape(g);
      			System.out.println("Stored shape");
        	}
		} catch(RemoteException e) {
			System.out.println("allShapes: " + e.getMessage());
		} catch(Exception e) {
			System.out.println("Lookup: " + e.getMessage());
			}
		
	}

}