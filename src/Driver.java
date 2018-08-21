import java.util.*;

public class Driver {
	
	public static void main (String[] args) {
		Vector[] arr;
		/*--------------- SAMPLE 01 ---------------*
		
		arr = new Vector[3];
		arr[0] = new Vector (new double[] {1, 2, -1}, 3);
		arr[1] = new Vector (new double[] {1, -3, 2}, 3);
		arr[2] = new Vector (new double[] {1, 1, -1}, 3);
		
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		
		Vector v = Vector.Gauss_Jordan (list, 3, new Vector (new double[] {4, 2, -1}, 3));
		
		System.out.println (v);
		System.out.println (Vector.span (list, 3));
		/*------------ END OF SAMPLE 1 ------------*/
		/*--------------- SAMPLE 02 ---------------*
		
		arr = new Vector[3];
		arr[0] = new Vector (new double[] {1, 1, 2}, 3);
		arr[1] = new Vector (new double[] {3, -2, 1}, 3);
		arr[2] = new Vector (new double[] {1, -1, 2}, 3);
		
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		
		Vector v = Vector.Gauss_Jordan (list, 3, new Vector (new double[] {10, -6, 10}, 3));
		
		System.out.println (v);
		System.out.println (Vector.span (list, 3));
		/*------------ END OF SAMPLE 2 ------------*/
		/*--------------- SAMPLE 03 ---------------*
		
		arr = new Vector[3];
		arr[0] = new Vector (new double[] {2, 1, -1}, 3);
		arr[1] = new Vector (new double[] {3, 1, -2}, 3);
		arr[2] = new Vector (new double[] {-1, 1, 3}, 3);
		
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		
		Vector v = Vector.Gauss_Jordan (list, 3, new Vector (new double[] {-7, 4, 15}, 3));
		
		System.out.println (v);
		System.out.println (Vector.span (list, 3));
		/*------------ END OF SAMPLE 3 ------------*/
		/*--------------- SAMPLE 04 ---------------*
		
		arr = new Vector[4];
		arr[0] = new Vector (new double[] {1, 0, -4, 2}, 4);
		arr[1] = new Vector (new double[] {-1, 1, 4, 1}, 4);
		arr[2] = new Vector (new double[] {3, 7, 1, 0}, 4);
		arr[3] = new Vector (new double[] {1, 1, -2, 1}, 4);
		
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		list.add (arr[3]);
		
		Matrix m = new Matrix (list, 4);
		System.out.print (m);
		
		// Vector v = Vector.Gauss_Jordan (list, 4, new Vector (new double[] {1, 5, 2, 3}, 4));
		
		// System.out.println (v);
		// System.out.println (Vector.span (list, 4));
		/*------------ END OF SAMPLE 4 ------------*/
		
		/*--------------- SAMPLE 05 ---------------*
		arr = new Vector[4];
		arr[0] = new Vector (new double[] {1, 0, -4}, 3);
		arr[1] = new Vector (new double[] {-1, 1, 4}, 3);
		arr[2] = new Vector (new double[] {3, 7, 1}, 3);
		arr[3] = new Vector (new double[] {1, 1, -2}, 3);
		
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		list.add (arr[3]);
		
		Matrix m = new Matrix (list, 3);
		System.out.print (m);
		/*------------ END OF SAMPLE 5 ------------*/
		
		/*--------------- SAMPLE 06 ---------------*/
		Matrix A = new Matrix (4);
		
		arr = new Vector[3];
		arr[0] = new Vector (new double[] {1, 2, 3, 4}, 4);
		arr[1] = new Vector (new double[] {4, 5, 6, 7}, 4);
		arr[2] = new Vector (new double[] {9, 8, 7, 6}, 4);
		List<Vector> list = Arrays.asList (arr);
		Matrix B = new Matrix (list, 4);
		
		System.out.print (A.times (B));
		
		/*------------ END OF SAMPLE 6 ------------*/
	}
	
}
