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
		/*------------ END OF SAMPLE 1 ------------*/
		/*--------------- SAMPLE 02 ---------------*/
		
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
		/*------------ END OF SAMPLE 2 ------------*/
	}
	
}
