/**
* ADVDISC MP1
* @author Aguila, Norielle E.
* @author Chan, Nyles S.
* @author Pillejera, Jasper Glen A.
*/
package vector;

public class vector {
	
	private double[] elements;
	
	/**
	* Initializes a vector of size equal to dimensions where all elements are 0
	* @param dimensions the size of the vector
	*/
	public vector (int dimensions) {
		elements = new double[dimensions];
	}
	
	/**
	* Creates a vector of size equal to the number of elements inputted
	* @param elements the values to be contained by this vector
	*/
	public vector (double... elements) {
		this.elements = new double[elements.length];
		for (int i = 0; i < elements.length; i++) {
			this.elements[i] = elements[i];
		}
	}
	
	/**
	* Creates a new vector to contain the sum of this vector and another vector
	* vector is undefined (null) if the dimensions of this vector and the other vector do not match
	* @param other another vector to be added to this vector
	* @return a new vector containing the sum of two vectors
	*/
	public vector add (vector other) {
		if (this.dim () != other.dim ())
			return null;
		
		vector output = new vector (this.dim ());
		
		for (int i = 0; i < this.dim (); i++) {
			output.setElement (i, this.elements[i] + other.elements[i]);
		}
		
		return output;
	}
	
	/**
	* Creates a new vector to contain the scaled version of this vector
	* @param scalar a value to be multiplied to each element of this vector
	* @return returns a new vector containing the scaled values of this vector
	*/
	public vector scale (double scalar) {
		vector output = new vector (this.dim ());
		
		for (int i = 0; i < output.dim (); i++) {
			output.setElement (i, elements[i] * scalar);
		}
		
		return output;
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
	
	/**
	* returns the comma separated values of the vector enclosed
	*		by square brackets []
	* @return string representation of this vector
	*/
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		sb.append ("[");
		
		for (int i = 0; i < dim (); i++) {
			sb.append (elements[i])
				.append ((i + 1 == dim () ? "" : ", "));
		}
		sb.append ("]");
		
		return sb.toString ();
	}
	
}