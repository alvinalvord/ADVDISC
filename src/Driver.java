import java.util.*;

public class Driver {
	
	public static void main (String[] args) {
		Vector[] arr;
		/*--------------- SAMPLE 01 ---------------*
			arr = new vector[3];
			vector a = new vector (5, 3, 5, 8, 2);
			vector b = new vector (9, 6, 8, 2, 1);
			vector c = new vector (1, 4, 4, 5, 3);
			vector d = new vector (9, 2, 2, 0, 5);
			vector e = new vector (7, 6, 3, 1, 0);
			
			arr[0] = a; arr[1] = b; arr[2] = c; arr[3] = d; arr[4] = e;
		/*------------ END OF SAMPLE 1 ------------*/
		/*--------------- SAMPLE 02 ---------------*
			arr = new vector[3];
			arr[0] = new vector (1, 1, 0, 1, 1, 1);
			arr[1] = new vector (1, 1, 1, 0, 0, 1);
			arr[2] = new vector (1, 1, 1, 1, 1, 0);
			arr[3] = new vector (1, 1, 1, 1, 1, 1);
			arr[4] = new vector (1, 0, 1, 1, 0, 1);
			arr[5] = new vector (1, 1, 1, 1, 1, 1);
			arr[6] = new vector (1, 0, 1, 1, 1, 0);
		/*------------ END OF SAMPLE 2 ------------*/
		/*--------------- SAMPLE 03 ---------------*
			arr = new vector[2];
			arr[0] = new vector (3, 2);
			arr[1] = new vector (1, 3);
		/*------------ END OF SAMPLE 3 ------------*/
		/*--------------- SAMPLE 04 ---------------*
			arr = new vector[3];
			arr[0] = new vector ((double)1);
			arr[1] = new vector ((double)2);
			arr[2] = new vector ((double)3);
		/*------------ END OF SAMPLE 4 ------------*/
		/*--------------- SAMPLE 05 ---------------*/
			arr = new Vector[3];
			arr[0] = new Vector (new double[] {0, 0, 5}, 3);
			arr[1] = new Vector (new double[] {0, 0, 10}, 3);
			arr[2] = new Vector (new double[] {1, 1, 10}, 3);
		/*------------ END OF SAMPLE 5 ------------*/
		List<Vector> list = new ArrayList<> ();
		list.add (arr[0]);
		list.add (arr[1]);
		list.add (arr[2]);
		Vector v = Vector.Gauss_Jordan (list, 3, new Vector (new double[] {1, 2, 3}, 3));
		
		System.out.println (v);
	}
	
}