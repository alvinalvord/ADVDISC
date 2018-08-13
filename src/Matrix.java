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

	/**
		Default constructor to create an identity matrix of a given dimension
	*/
	public Matrix(int dimension){
		
		this.vectors = new Vector[dimension];
		
		for(int i = 0; i < dimension; i++){
			double[] temp = new double[dimension];
			temp[i] = 1;
			vectors[i] = new Vector(temp, dimension);
		}
		
		numRow = numCol = dimension;
	}

	/**
		Default constructor converting a list of Vectors into a matrix
		@param dimension - length of each Vector in the list
	*/
	public Matrix (List<Vector> list, int dimension){
		
		List<Vector> temp = new ArrayList<>();
		
		System.out.println("Entered vectors: ");
		
		for(int i = 0; i < list.size(); i++){
			double[] elements = new double[dimension];
			
			Vector tempVector = list.get(i);
			
			System.out.println(tempVector.toString());
			
			for(int j = 0; j < dimension; j++)
				elements[j] = tempVector.getElement(j);
			
			temp.add(new Vector(elements, dimension));
			
		}
		
		vectors = new Vector[list.size()];
		
		for(int i = 0; i < temp.size(); i++)
			vectors[i] = temp.get(i);
		
		numRow = vectors.length;
		numCol = dimension;
	}
	
	public Matrix times(Matrix other){
		List<Vector> outVectors = new ArrayList<Vector>();
		Matrix out = null;
		
		// check if multiplication is legal
		// should be n x m * m x p
		if(this.numCol != other.getNumRow())
			return null;
		
		// initialize list of vectors
		for(int i = 0; i < other.numCol; i++){
			outVectors.add(new Vector(numRow));
		}
		
		for(int x = 0; x < outVectors.size(); x++){
			for(int i = 0; i < this.numRow; i++){
				
				double result = 0;
				
				for(int j = 0; j < this.numCol; j++){
					System.out.println("[" + i + "] [" + j + "]");
					
					for(int k = 0; k < other.numCol; k++){
						
						System.out.println(vectors[i].getElement(j) + "*" + other.getVectors()[j].getElement(k));
						
						result += vectors[i].getElement(j) * other.getVectors()[j].getElement(k);
					}
					System.out.println(result);
				}
				System.out.println();
				
				// not working
				outVectors.get(x)
					.setElement(i, result);
			}
		}
		
		out = new Matrix(outVectors, numCol);
		
		return out;
		
	}
	
	public int getNumRow(){
		return numRow;
	}
	
	public int getNumCol(){
		return numCol;
	}
	
	public Vector[] getVectors(){
		return vectors;
	}
	
	public void printMatrix(){
		System.out.println("Representation: ");
		
		for(int i = 0; i < vectors.length; i++){
			System.out.println(vectors[i].toString());
		}
		
		System.out.println("Rows:" + numRow);
		System.out.println("Cols:" + numCol);
		System.out.println();
	}
	
	
	
	/*
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
					element += a.vectors[x].getElement(z) * b.vectors[y].getElement(x); //BUG: can't .get()???
				}
				product.vectors[y].setElement(z, element); //BUG: can't .get()???
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
	
	/*
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
	*/
}