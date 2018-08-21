/**
* ADVDISC S18 MP1
* @author Aguila, Norielle E.
* @author Chan, Nyles S.
* @author Pillejera, Jasper Glen A.
*/

import java.util.List;
import java.util.ArrayList;

public class Vector {
	
	private double[] elements;
	private int dimension;
	
	/**
	* Initializes a vector of size equal to dimensions where all elements are 0
	* @param dimension the size of the vector
	*/
	public Vector (int dimension) {
		this.dimension = dimension;
		elements = new double[dimension];
	}
	
	/**
	* Initializes a vector with the elements of the input array
	* @param array input array
	* @param dimension size of the array
	*/
	public Vector (double[] array, int dimension) {
		this.dimension = dimension;
		this.elements = new double[dimension];
		for (int i = 0; i < dimension; i++) {
			elements[i] = array[i];
		}
	}
	
	/**
	* Creates a new vector to contain the sum of this vector and another vector
	* vector is undefined (null) if the dimensions of this vector and the other vector do not match
	* @param addend another vector to be added to this vector
	* @return a new vector containing the sum of two vectors
	*/
	public Vector add (Vector addend) {
		if (this.dimension != addend.dimension) return null;
		
		Vector output = new Vector (this.dimension);
		
		for (int i = 0; i < this.dimension; i++) {
			output.elements[i] = this.elements[i] + addend.elements[i];
		}
		
		return output;
	}
	
	/**
	* Creates a new vector to contain the scaled version of this vector
	* @param scalar a value to be multiplied to each element of this vector
	* @return returns a new vector containing the scaled values of this vector
	*/
	public Vector scale (double scalar) {
		Vector output = new Vector (this.elements, this.dimension);
		
		for (int i = 0; i < this.dimension; i++) {
			output.elements[i] *= scalar;
		}
		
		return output;
	}
	
	/**
	* Calls Gauss_Jordan method and returns the span of the list of vectors
	* @param vectors input list of vectors
	* @param dimension the size of each of the vectors
	*/
	public static int span (List<Vector> vectors, int dimension) {
		Matrix matrix = new Matrix (vectors, dimension);
		Matrix inverse = new Matrix (dimension);
		List<Integer> indices = new ArrayList <> ();
		Matrix.MutableDouble determinant = new Matrix.MutableDouble (1.0);
		
		Matrix.toRowEchelon (matrix, inverse, new Vector (dimension), indices, determinant);
		return indices.size ();
	}
	
	/**
	* Performs Gauss Jordan Elimination and returns the constant vector
	* @param vectors input list of vectors
	* @param dimension the size of each of the vectors
	* @param constants the output vector
	* @return null if dimension and constant vector dimension does not match; otherwise, returns the constants values after performing Gauss Jordan Elimination
	*/
	public static Vector Gauss_Jordan (List<Vector> vectors, int dimension, Vector constants) {
		if (dimension != constants.dimension) return null;
		
		Matrix matrix = new Matrix (vectors, dimension);
		Matrix inverse = new Matrix (dimension);
		List<Integer> indices = new ArrayList<>();
		Matrix.MutableDouble determinant = new Matrix.MutableDouble (1.0);
		
		Matrix.toRowEchelon (matrix, inverse, constants, indices, determinant);
		
		Matrix.toReducedRowEchelon (matrix, inverse, constants, indices);
		
		for (int i = 0; i < matrix.getVectors ().length; i++) {
			boolean flag = false;
			
			for (int j = 0; j < matrix.getVectors ()[i].dimension; j++) {
				if (matrix.getVectors ()[i].getElement (j) != 0) {
					flag = true;
					break;
				}
			}
			
			if (!flag) return null;
		}
		
		return constants;
	}
	
	public int getDimension () {
		return dimension;
	}
	
	public double[] getElements () {
		return elements;
	}
	
	public double getElement (int index) {
		return elements[index];
	}
	
	public void setElement (int index, double value) {
		elements[index] = value;
	}
	
	/**
	* returns the comma separated values of the vector enclosed
	*		by square brackets []
	* @return string representation of this vector
	*/
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		
		for (int i = 0; i < dimension; i++) {
			sb.append (String.format ("%.2f", elements[i] + 0.0))
				.append ((i + 1 == dimension ? "" : ", "));
		}
		sb.append ("]");
		
		return sb.toString ();
	}
	
}
