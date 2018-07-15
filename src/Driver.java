import vector.vector;

public class Driver {
	
	public static void main (String[] args) {
		vector a = new vector (5, 3, 5, 8, 2);
		vector b = new vector (9, 6, 8, 2, 1);
		vector c = new vector (1, 4, 4, 5, 3);
		vector d = new vector (9, 2, 2, 0, 5);
		vector e = new vector (7, 6, 3, 1, 0);
		
		// System.out.println (a);
		// System.out.println (b);
		// System.out.println (a.add (b));
		// System.out.println (a.scale (5));
		// System.out.println (a.resize (4).setElement (3, 4));
		
		vector.performGaussJordanElimination (a, b, c, d, e);
	}
	
}