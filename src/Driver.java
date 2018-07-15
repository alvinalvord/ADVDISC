import vector.vector;

public class Driver {
	
	public static void main (String[] args) {
		vector[] arr = new vector[7];
		/* 
			vector a = new vector (5, 3, 5, 8, 2);
			vector b = new vector (9, 6, 8, 2, 1);
			vector c = new vector (1, 4, 4, 5, 3);
			vector d = new vector (9, 2, 2, 0, 5);
			vector e = new vector (7, 6, 3, 1, 0);
			
			arr[0] = a; arr[1] = b; arr[2] = c; arr[3] = d; arr[4] = e;
		 */
		
		arr[0] = new vector (1, 1, 0, 1, 1, 1);
		arr[1] = new vector (1, 1, 1, 0, 0, 1);
		arr[2] = new vector (1, 1, 1, 1, 1, 0);
		arr[3] = new vector (1, 1, 1, 1, 1, 1);
		arr[4] = new vector (1, 0, 1, 1, 0, 1);
		arr[5] = new vector (1, 1, 1, 1, 1, 1);
		arr[6] = new vector (1, 0, 1, 1, 1, 0);
		
		vector.performGaussJordanElimination (arr);
	}
	
}