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
		
		/*--------------- SAMPLE 06 ---------------*
		Matrix A = new Matrix (4);
		
		arr = new Vector[3];
		arr[0] = new Vector (new double[] {1, 2, 3, 4}, 4);
		arr[1] = new Vector (new double[] {4, 5, 6, 7}, 4);
		arr[2] = new Vector (new double[] {9, 8, 7, 6}, 4);
		List<Vector> list = Arrays.asList (arr);
		Matrix B = new Matrix (list, 4);
		
		System.out.print (A.times (B));
		
		/*------------ END OF SAMPLE 6 ------------*/
		/*--------------- SAMPLE 07 ---------------*
		List<Vector> list = new ArrayList <Vector> ();
		
		list.add (new Vector (new double[]{1,2,3}, 3));
		list.add (new Vector (new double[]{4,5,6}, 3));
		list.add (new Vector (new double[]{7,8,9}, 3));
		
		Matrix A = new Matrix (list, 3);
		
		System.out.println ("input: ");
		System.out.println (A);
		
		System.out.println ("\nGJE: ");
		System.out.println (Vector.Gauss_Jordan (list, 3, new Vector (new double[]{1,2,2}, 3)));
		
		System.out.println ("\nDeterminant: ");
		System.out.println (A.det ());
		
		System.out.println ("\nInverse: ");
		System.out.println (A.inverse ());
		
		System.out.println ("\nTranspose: ");
		System.out.println (A.transpose ());
		/*------------ END OF SAMPLE 7 ------------*/
		/*--------------- SAMPLE 08 ---------------*
		arr = new Vector[2];
		arr[0] = new Vector (new double[] {1, 3}, 2);
		arr[1] = new Vector (new double[] {3, 9}, 2);

		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);

		Matrix trix = new Matrix(list, 2);

		//determinant should be 0
		
		System.out.println (trix.det());
		/*------------ END OF SAMPLE 8 ------------*/
		/*--------------- SAMPLE 09 ---------------*/
		List<Vector> list = new ArrayList <Vector> ();
		
		list.add (new Vector (new double[]{1.5,2,4}, 3));
		list.add (new Vector (new double[]{3,4,8}, 3));
		list.add (new Vector (new double[]{6,1.9,9}, 3));
		
		Matrix A = new Matrix (list, 3);
		
		List<Vector> list2 = new ArrayList <Vector> ();
		
		list2.add (new Vector (new double[]{8,5,2}, 3));
		list2.add (new Vector (new double[]{7.8,5,1}, 3));
		list2.add (new Vector (new double[]{7,2,3}, 3));
		
		Matrix B = new Matrix (list2, 3);
		
		System.out.println ("input: ");
		System.out.println (A);
		
		System.out.println ("\nGJE: ");
		System.out.println (Vector.Gauss_Jordan (list, 3, new Vector (new double[]{1,2,2}, 3)));
		
		System.out.println ("\nDeterminant: ");
		System.out.println (A.det ());
		
		System.out.println ("\nInverse: ");
		System.out.println (A.inverse ());
		
		System.out.println ("\nTranspose: ");
		System.out.println (A.transpose ());
		
		System.out.println ("input: ");
		System.out.println (B);
		
		System.out.println ("\nGJE: ");
		System.out.println (Vector.Gauss_Jordan (list2, 3, new Vector (new double[]{1,2,2}, 3)));
		
		System.out.println ("\nDeterminant: ");
		System.out.println (B.det ());
		
		System.out.println ("\nInverse: ");
		System.out.println (B.inverse ());
		
		System.out.println ("\nTranspose: ");
		System.out.println (B.transpose ());
		
		System.out.println(A.times(B));
		/*------------ END OF SAMPLE 9 ------------*/
	}
	
}
