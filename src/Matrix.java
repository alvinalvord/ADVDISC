/**
* ADVDISC S18 MP2
* @author Aguila, Norielle E.
* @author Chan, Nyles S.
* @author Pillejera, Jasper Glen A.
*/

import java.util.List;
import java.util.ArrayList;

public class Matrix {

	private Vector[] vectors;
	private final int numRow;
	private final int numCol;

	/*
		Default constructor to create an identity matrix of a given dimension
	*/
	public Matrix(int dimension){
		this.vectors = new Vector[dimension];
		
		for(int i = 0; i < dimension; i++){
			double[] temp = new double[dimension];
			temp[i] = 1;
			
			vectors[i] = new Vector(temp, dimension);
		}

		numRow = vectors.length;
		numCol = dimension;
	}

	/*
		Default constructor converting a list of Vectors into a matrix
		@param dimension - length of each Vector in the list
	*/
	public Matrix (List<Vector> list, int dimension){
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
		
		numRow = vectors.length;
		numCol = dimension;
	}

	public Matrix times (Matrix other) {
		int dimension = this.numCol; 
		Matrix product = new Matrix (dimension);
		double element = 0;
		for (int z = 0; z < dimension; z++) {
			for (int y = 0; y < dimension; y++) {
				element = 0;
				for (int x = 0; x < dimension; x++) {
					element += this.vectors[x].getElement(z) * other.vectors[y].getElement(x);
				}
				product.vectors[y].setElement(z, element);
			}
		}
		return product;
	} //this.times(other) --> product

	//stuff not considered:
	//size mismatch not yet handled
	//different sizes but valid multiplied matrices (currently, the dimension refers to same sizes for all, so n x n and n x n)

	public double det() {
		double determinant = 0;
		//gauss-jordan
		return determinant;
	} //m.det() --> determinant

	public Matrix inverse() {
		Matrix inversed = new Matrix(this.numCol);
		//gauss-jordan
		//perform(blackMagic);
		return inversed;
	} //m.inverse() --> inverse

	//return null if not invertible (no inverse)

	/**
	* returns the comma separated values of the vector enclosed
	*		by square brackets []
	* @return string representation of this vector
	*/
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		
		for (int i = 0; i < vectors[i].getDimension(); i++) {
			sb.append (String.format ("%.2f", vectors[i].getElement(i) + 0.0))
				.append ((i + 1 == vectors[i].getDimension() ? "" : ", "));
		}
		sb.append ("]");
		
		return sb.toString ();
	}

}