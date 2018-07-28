/**
* ADVDISC MP1
* @author Aguila, Norielle E.
* @author Chan, Nyles S.
* @author Pillejera, Jasper Glen A.
*/
package Vector;

public class Vector {
	
	private double[] elements;
	
	/**
	* Initializes a vector of size equal to dimensions where all elements are 0
	* @param dimensions the size of the vector
	*/
	public Vector (int dimension) {
		elements = new double[dimension];
	}
	
	/**
	* Creates a vector of size equal to the number of elements inputted
	* @param elements the values to be contained by this vector
	*/
	public Vector (double[] array, int dimension) {
		this.array = new double[dimension]; //formerly array.length
		for (int i = 0; i < dimension; i++) { //array.length
			this.array[i] = array[i];
		}
	}
	
	/**
	* Creates a new vector to contain the sum of this vector and another vector
	* vector is undefined (null) if the dimensions of this vector and the other vector do not match
	* @param addend another vector to be added to this vector
	* @return a new vector containing the sum of two vectors
	*/
	public Vector add (Vector addend) {
		if (this.dim () != addend.dim ())
			return null;
		
		Vector output = new Vector (this.dim ());
		
		for (int i = 0; i < this.dim (); i++) {
			output.setElement (i, this.elements[i] + addend.elements[i]);
		}
		
		return output;
	}
	
	/**
	* Creates a new vector to contain the scaled version of this vector
	* @param scalar a value to be multiplied to each element of this vector
	* @return returns a new vector containing the scaled values of this vector
	*/
	public Vector scale (double scalar) {
		Vector output = new Vector (this.dim ());
		
		for (int i = 0; i < output.dim (); i++) {
			output.setElement (i, elements[i] * scalar);
		}
		
		return output;
	}
	
	public static vector[] performGaussJordanElimination (vector... input) {
		// cannot be performed if dimensions are not NxM
		int len = input[0].dim ();
		for (int i = 1; i < input.length; i++) {
			if (input[i].dim () != len)
				return null;
		}
		
		// create matrix
		vector[] arr = new vector[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new vector (input.length);
			for (int j = 0; j < input.length; j++) {
				arr[i].setElement (j, input[j].getElement (i));
			}
		}
		
		vector.printVectorArray (arr);
		
		int j = 0;
		java.util.List <Integer> span = new java.util.ArrayList<> ();
		for (int i = 0; i < arr.length; i++) {
			
			// search for non zero at j index
			boolean flag = false;
			do {
				if (j >= arr[i].dim ())
					break;
				
				for (int k = i; k < arr.length; k++) {
					if (arr[k].getElement (j) != 0) {
						flag = true;
						break;
					}
				}
				
				if (!flag) j++;
			} while (!flag);
			
			if (!flag) break;
			
			span.add (j);
			
			// sort array -> all zeroes below
			int x = i, y = arr.length - 1;
			while (x < y) {
				while (arr[y].getElement (j) == 0) y--;
				if (arr[x].getElement (j) == 0) {
					vector temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp; 
					y--;
				}
				x++;
			}
			
			// scale for row echelon form
			arr[i] = arr[i].scale (1.0 / arr[i].getElement (j));
			// scale then subtract to zero indices below [i][j]
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[k].getElement (j) != 0) {
					arr[k] = arr[k].scale (- 1.0 / arr[k].getElement (j));
					arr[k] = arr[k].add (arr[i]);
				}
			}
		
			j++;
		
			vector.printVectorArray (arr);
		}
		
		for (int i = 1; i < span.size (); i++) {
			j = span.get (i);
			
			for (int k = i - 1; k >= 0; k--) {
				vector temp = new vector (arr[i]);
				temp = temp.scale (- arr[k].getElement (j) / arr[i].getElement (j));
				arr[k] = arr[k].add (temp);
			}
			
			vector.printVectorArray (arr);
			
		}
		
		
		System.out.println ("span: " + span.size ());
		
		return arr;
	}
	
	/** 
	* @return returns the size/dimensions of this vector
	*/
	public int dim () {
		return elements.length;
	}
	
	/**
	* @return returns the array of elements
	*/
	public double[] getElements () {
		return elements;
	}
	
	/**
	* @param index 0 indexing where the value will be placed
	* @param value the value to be stored
	* @return returns this vector for easier chaining of methods
	*/
	public vector setElement (int index, double value) {
		elements[index] = value;
		return this;
	}
	
	/**
	* @param index 0 indexing, where the value at the specific index will be returned
	* @return returns the value at the specific index
	*/
	public double getElement (int index) {
		return elements[index];
	}
	
	/**
	* resizes the vector and copies all elements from the old vector to the new one
	* elements will be truncated if the size gets smaller and 0s will be appended 
	* if size if greater than the old vector size
	* @param size the size of the new array
	* @return returns this vector for easier chaining of methods
	*/
	public vector resize (int size) {
		double[] newArray = new double[size];
		for (int i = 0; i < size && i < dim (); i++) {
			newArray[i] = elements[i];
		}
		elements = newArray;
		return this;
	}
	
	public static void printVectorArray (vector... arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println (arr[i]);
		}
		System.out.println ();
	}
	
	/**
	* returns the comma separated values of the vector enclosed
	*		by square brackets []
	* @return string representation of this vector
	*/
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		
		for (int i = 0; i < dim (); i++) {
			sb.append (String.format ("%.2f", elements[i] + 0.0))
				.append ((i + 1 == dim () ? "" : ", "));
		}
		sb.append ("]");
		
		return sb.toString ();
	}
	
}