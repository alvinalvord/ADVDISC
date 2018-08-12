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
		this.dimension = dimension;

		List<Vector> temp = new ArrayList<>();
		
		for(int i = 0; i < dimension; i++){
			double[] elements = new double[list.size()];
			Vector tempVector = list.get(i);
		
			for(int j = 0; j < list.size(); j++){
				elements[j] = tempVector.getElement(j);
			}
			temp.add(new Vector(elements, dimension));
		}
		
		vectors = new Vector[list.size()];
		
		for(int i = 0; i < temp.size(); i++){
			vectors[i] = temp.get(i);
		}

		this.vectors = vectors;
	}

	public static Matrix times (Matrix other) {
		int dimension = other.dimension; 
		Matrix product = new Matrix (dimension);
		Matrix a = this; //BUG: how do you reference self?
		Matrix b = other;
		double element = 0;
		for (int z = 0; z < dimension; z++) {
			for (int y = 0; y < dimension; y++) {
				element = 0;
				for (int x = 0; x < dimension; x++) {
					element += a.get(x).vectors[z] * b.get(y).vectors[x]; //BUG: can't .get()???
				}
				product.get(y).vectors[z] = element; //BUG: can't .get()???
			}
		}
		return product;
	} //a.times(b) --> product

	//stuff not considered:
	//size mismatch not yet handled
	//different sizes but valid multiplied matrices (currently, the dimension refers to same sizes for all, so n x n and n x n)


	/*
	public static double det() {
		//gauss-jordan
		//return determinant;
	} //m.det() --> determinant

	public static Matrix inverse() {
		//return null if not invertible (no inverse)
		//return inversed;
	} //m.inverse() --> inverse
	*/

	/**
	* returns the comma separated values of the vector enclosed
	*		by square brackets []
	* @return string representation of this vector
	*/
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		
		for (int i = 0; i < dimension; i++) {
			sb.append (String.format ("%.2f", vectors[i] + 0.0))
				.append ((i + 1 == dimension ? "" : ", "));
		}
		sb.append ("]");
		
		return sb.toString ();
	}

}