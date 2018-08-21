import java.util.*;

public class Test {
	
	static void gje1 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{2,3}, 2));
		list.add (new Vector (new double[]{3,5}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{5,8}, 2));
		
		System.out.println ("test 1: "  + out);
	}
	
	static void gje2 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{0,2}, 2));
		list.add (new Vector (new double[]{2,7}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{2,9}, 2));
		
		System.out.println ("test 2: "  + out);
	}
	
	static void gje3 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{4,2}, 2));
		list.add (new Vector (new double[]{0,0}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{1,2}, 2));
		
		System.out.println ("test 3: "  + out);
	}
	
	static void gje4 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{0,0}, 2));
		list.add (new Vector (new double[]{0,0}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{1,1}, 2));
		
		System.out.println ("test 4: "  + out);
	}
	
	static void gje5 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,0,0}, 3));
		list.add (new Vector (new double[]{0,1,0}, 3));
		list.add (new Vector (new double[]{0,0,1}, 3));
		Vector out = Vector.Gauss_Jordan (list, 3, new Vector (new double[]{1,1,1}, 3));
		
		System.out.println ("test 5: "  + out);
	}
	
	static void gje6 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,3}, 3));
		list.add (new Vector (new double[]{3,4,6}, 3));
		list.add (new Vector (new double[]{1,0,1}, 3));
		Vector out = Vector.Gauss_Jordan (list, 3, new Vector (new double[]{5,6,10}, 3));
		
		System.out.println ("test 6: "  + out);
	}
	
	static void gje7 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,4}, 3));
		list.add (new Vector (new double[]{1,2,6}, 3));
		list.add (new Vector (new double[]{0,2,3}, 3));
		Vector out = Vector.Gauss_Jordan (list, 3, new Vector (new double[]{2,6,13}, 3));
		
		System.out.println ("test 7: "  + out);
	}
	
	static void gje8 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,2,3}, 4));
		list.add (new Vector (new double[]{2,4,4,2}, 4));
		list.add (new Vector (new double[]{5,8,10,7}, 4));
		list.add (new Vector (new double[]{7,16,14,2}, 4));
		Vector out = Vector.Gauss_Jordan (list, 4, new Vector (new double[]{0,0,0,0}, 4));
		
		System.out.println ("test 8: "  + out);
	}
	
	static void gje9 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,0,0,0,0}, 5));
		list.add (new Vector (new double[]{0,1,0,0,0}, 5));
		list.add (new Vector (new double[]{0,0,1,0,0}, 5));
		list.add (new Vector (new double[]{0,0,0,1,0}, 5));
		list.add (new Vector (new double[]{0,0,0,0,1}, 5));
		Vector out = Vector.Gauss_Jordan (list, 5, new Vector (new double[]{1,1,1,1,1}, 5));
		
		System.out.println ("test 9: "  + out);
	}
	
	static void gje10 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,3,4,5,6}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{1,2,3,4,5,6}, 6));
		Vector out = Vector.Gauss_Jordan (list, 6, new Vector (new double[]{0,0,0,0,0,0}, 6));
		
		System.out.println ("test 10: "  + out);
	}
	
	static void gje11 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,0,0,0,0,0,0,0}, 8));
		list.add (new Vector (new double[]{0,1,0,0,0,0,0,0}, 8));
		list.add (new Vector (new double[]{0,0,1,0,0,0,0,0}, 8));
		list.add (new Vector (new double[]{0,0,0,1,0,0,0,0}, 8));
		list.add (new Vector (new double[]{0,0,0,0,1,0,0,0}, 8));
		list.add (new Vector (new double[]{0,0,0,0,0,1,0,0}, 8));
		list.add (new Vector (new double[]{0,0,0,0,0,0,1,0}, 8));
		list.add (new Vector (new double[]{0,0,0,0,0,0,0,1}, 8));
		Vector out = Vector.Gauss_Jordan (list, 8, new Vector (new double[]{1,1,1,1,1,1,1,1}, 8));
		
		System.out.println ("test 11: "  + out);
	}
	
	static void gje12 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1, 2, 2, 3}, 4));
		list.add (new Vector (new double[]{2, 4, 5, 2}, 4));
		list.add (new Vector (new double[]{5, 8, 10, 7}, 4));
		list.add (new Vector (new double[]{7, 16, 14, 2}, 4));
		Vector out = Vector.Gauss_Jordan (list, 4, new Vector (new double[]{14, 30, 31, 14}, 4));
		
		System.out.println ("test 12: "  + out);
	}
	
	static void gje13 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{0, 2}, 2));
		list.add (new Vector (new double[]{0, 4}, 2));
		list.add (new Vector (new double[]{0, 9}, 2));
		list.add (new Vector (new double[]{0, 2}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{2, 4}, 2));
		
		System.out.println ("test 13: "  + out);
	}
	
	static void gje14 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,2,2,2,2}, 6));
		list.add (new Vector (new double[]{2,1,2,2,2,2}, 6));
		list.add (new Vector (new double[]{2,2,1,2,2,2}, 6));
		Vector out = Vector.Gauss_Jordan (list, 6, new Vector (new double[]{0,0,0,0,0,0}, 6));
		
		System.out.println ("test 14: "  + out);
	}
	
	static void gje15 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{2,1}, 2));
		Vector out = Vector.Gauss_Jordan (list, 2, new Vector (new double[]{2,3}, 2));
		
		System.out.println ("test 15: "  + out);
	}
	
	static void s1 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1, 0, 0, 0, 0}, 5));
		list.add (new Vector (new double[]{0, 1, 0, 0, 0}, 5));
		list.add (new Vector (new double[]{0, 0, 1, 0, 0}, 5));
		list.add (new Vector (new double[]{0, 0, 0, 1, 0}, 5));
		list.add (new Vector (new double[]{0, 0, 0, 0, 1}, 5));
		int out = Vector.span (list, 5);
		
		System.out.println ("test 1: "  + out);
	}
	
	static void s2 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{2,3}, 2));
		list.add (new Vector (new double[]{3,5}, 2));
		int out = Vector.span (list, 2);
		
		System.out.println ("test 2: "  + out);
	}
	
	static void s3 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,3,4,5,6}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{10,0,0,0,0,10}, 6));
		list.add (new Vector (new double[]{1,2,3,4,5,6}, 6));
		int out = Vector.span (list, 6);
		
		System.out.println ("test 3: "  + out);
	}
	
	static void s4 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1, 0, 0, 0, 0, 0, 0}, 7));
		list.add (new Vector (new double[]{0, 1, 0, 0, 0, 0, 0}, 7));
		list.add (new Vector (new double[]{0, 0, 1, 0, 0, 0, 0}, 7));
		list.add (new Vector (new double[]{0, 0, 0, 1, 0, 0, 0}, 7));
		list.add (new Vector (new double[]{0, 0, 0, 0, 1, 0, 0}, 7));
		list.add (new Vector (new double[]{0, 0, 0, 0, 0, 1, 0}, 7));
		list.add (new Vector (new double[]{0, 0, 0, 0, 0, 0, 1}, 7));
		int out = Vector.span (list, 7);
		
		System.out.println ("test 4: "  + out);
	}
	
	static void s5 () {
		List<Vector> list = new ArrayList<> ();
		list.add (new Vector (new double[]{1,2,2,2,2,2}, 6));
		list.add (new Vector (new double[]{2,1,2,2,2,2}, 6));
		list.add (new Vector (new double[]{2,2,1,2,2,2}, 6));
		int out = Vector.span (list, 6);
		
		System.out.println ("test 5: "  + out);
	}
	
	public static void main (String[] args) {
		gje1 ();
		gje2 ();
		gje3 ();
		gje4 ();
		gje5 ();
		gje6 ();
		gje7 ();
		gje8 ();
		gje9 ();
		gje10 ();
		gje11 ();
		gje12 ();
		gje13 ();
		gje14 ();
		gje15 ();
		s1 ();
		s2 ();
		s3 ();
		s4 ();
		s5 ();
	}
	
}