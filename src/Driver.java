import vector.vector;

public class Driver {
	
	public static void main (String[] args) {
		vector a = new vector (1,0,3);
		vector b = new vector (5,6,7);
		vector c = new vector (8, 9, 0);
		
		// System.out.println (a);
		// System.out.println (b);
		// System.out.println (a.add (b));
		// System.out.println (a.scale (5));
		// System.out.println (a.resize (4).setElement (3, 4));
		
		vector.performGaussJordanElimination (a, b, c);
	}
	
}