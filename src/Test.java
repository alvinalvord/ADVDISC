import java.util.*;

public class Test{
	public static void main(String ARG[]){
		List<Vector> list = new ArrayList<Vector>();
		
		list.add(new Vector(new double[]{1}, 1));
		list.add(new Vector(new double[]{2}, 1));
//		list.add(new Vector(new double[]{4, 3}, 2));
		
		List<Vector> list2 = new ArrayList<Vector>();
		list2.add(new Vector(new double[]{4, 5}, 2));
//		list2.add(new Vector(new double[]{5}, 1));
		
		Matrix m = new Matrix(list, 1);
		
		m.printMatrix();
		
		Matrix other = new Matrix(list2, 2);
		other.printMatrix();
		
		Matrix out = m.times(other);
		
		if(out == null)
			System.out.println("MULTIPLICATION INVALID");
		else
			System.out.println("MUTIPLICATION VALID");
//		out.printMatrix();
		
	}
}