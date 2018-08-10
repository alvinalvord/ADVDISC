/**
* ADVDISC S18 MP1
* @author Aguila, Norielle E.
* @author Chan, Nyles S.
* @author Pillejera, Jasper Glen A.
*/

import java.util.List;
import java.util.ArrayList;

public class Matrix {

	private Vector[] vectors;
	private int dimension;

	/*
		Default constructor to create an identity matrix of a given dimension
	*/
	public Matrix(int dimension){
		this.dimension = dimension;
		
		this.vectors = new Vector[dimension];
		
		for(int i = 0; i < dimension; i++){
			double[] temp = new double[dimension];
			temp[i] = 1;
			
			vectors[i] = new Vector(temp, dimension);
		}
	}

	/*
		Default constructor converting a list of Vectors into a matrix
		@param dimension - length of each Vector in the list
	*/
	public Matrix (List<Vector> list, int dimension){
		List<Vector> temp = new List<>();
		
		for(int i = 0; i < dimension; i++){
			double[] elements = new double[list.size()];
		
			for(int i = 0; i < list.size(); i++){
				Vector tempVector = list.get(i);
				elements[i] = tempVector[index];
			}
		}
		
		vectors = new Vector[list.size];
		
		for(int i = 0; i < list.size(); i++){
			vectors[i] = temp.get(i);
		}
	}

	public static Matrix times (Matrix other) {
		//size mismatch must be handled
		//return product;
	} //a.times(b) --> product
	
	public static double det() {
		//gauss-jordan
		//return determinant;
	} //m.det() --> determinant

	public static Matrix inverse() {
		//return null if not invertible (no inverse)
		//return inversed;
	} //m.inverse() --> inverse

}