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
	private int vectorSpan;
	
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
	* Returns an element of the Vector's one-dimensional double array.
	* @param index of the array
	*/
	public double getElement(int index) {
		return elements[index];
	}

	/**
	* Returns and modifies an element of the Vector's one-dimensional double array given the index number.
	* @param index of the array to be modified
	* @param element to be set
	*/
	public double setElement(int index, double element) {
		return elements[index] = element;
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
		return Gauss_Jordan (vectors, dimension, 
			new Vector (dimension)).vectorSpan;
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
		
		Vector[] arr = new Vector[dimension];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Vector (vectors.size ());
			for (int j = 0; j < vectors.size (); j++) {
				arr[i].elements[j] = vectors.get (j).elements[i];
			}
		}
		
		int j = 0;
		List<Integer> indices = new ArrayList <> ();
		for (int i = 0; i < arr.length; i++) {
			
			boolean flag = false;
			do {
				if (j >= arr[i].dimension) break;
				
				for (int k = i; k < arr.length; k++) {
					if (arr[k].elements[j] != 0) {
						flag = true; break;
					}
				}
				
				if (!flag) j++;
			} while (!flag);
			
			if (!flag) break;
			
			indices.add (j);
			
			int x = i, y = arr.length - 1;
			
			// sort array -> all zeroes below
			while (x < y) {
				while (arr[y].elements[j] == 0) y--;
				if (arr[x].elements[j] == 0) {
					Vector temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
					
					double tempconst = constants.elements[x];
					constants.elements[x] = constants.elements[y];
					constants.elements[y] = tempconst;
					y--;
				}
				x++;
			}
			
			// scale for row echelon form
			constants.elements[i] *= 1.0 / arr[i].elements[j];
			arr[i] = arr[i].scale (1.0 / arr[i].elements[j]);
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[k].elements[j] != 0) {
					constants.elements[k] *= (-1.0 / arr[k].elements[j]);
					arr[k] = arr[k].scale (- 1.0 / arr[k].elements[j]);
					
					constants.elements[k] += constants.elements[i];
					arr[k] = arr[k].add (arr[i]);
				}
			}
			j++;
		}
		
		for (int i = 1; i < indices.size (); i++) {
			j = indices.get (i);
			
			for (int k = i - 1; k >= 0; k--) {
				Vector temp = new Vector (arr[i].elements, arr[i].dimension);
				double tempconst = constants.elements[i];
				
				tempconst *= (-arr[k].elements[j] / arr[i].elements[j]);
				temp = temp.scale (-arr[k].elements[j] / arr[i].elements[j]);
				
				constants.elements[k] += tempconst;
				arr[k] = arr[k].add (temp);
			}
			
		}
		
		constants.vectorSpan = indices.size ();
		return constants;
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
