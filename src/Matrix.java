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
		if(this.numRow != other.numCol)
			return null;

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
	//different sizes but valid multiplied matrices (currently, the dimension refers to same sizes for all, so n x n and n x n) --> (not sure if this falls under size mismatch as well)

	public double det() {
		if(this.numRow != other.numCol)
			return null;

		double determinant = Gauss_Jordan();
		List<Vector> list = new ArrayList<>();
		for (int i = 0; i < numCol; i++)
			list.add(vectors[i]);

		if(this.vectors[0].span(list, numCol) < this.numCol)
			return 0;
		else return 1/determinant;
	} //m.det() --> determinant

	public Matrix inverse() {
		Matrix inversed = new Matrix(this.numCol);
		//gauss-jordan
		//perform(blackMagic);
		return inversed;
	} //m.inverse() --> inverse

	//return null if not invertible (no inverse)

	/**
	* Performs half of Gauss-Jordan Elimination and returns the constant
	* @return null if dimension and constant vector dimension does not match; otherwise, returns the constants values after performing Gauss-Jordan Elimination
	*/
	public double Gauss_Jordan() {
		if (this.numCol != this.numRow) return 0;

		double constant = 1; //because 1st step is multiply...?
		int dimension = this.numCol;
		
		Vector[] arr = new Vector[dimension];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Vector (this.vectors.length);
			for (int j = 0; j < this.vectors.length; j++) {
				arr[i].setElement(j, this.vectors[j].getElement(i));
			}
		}
		
		int j = 0;
		List<Integer> indices = new ArrayList <> ();
		for (int i = 0; i < arr.length; i++) {
			
			boolean flag = false;
			do {
				if (j >= arr[i].getDimension()) break;
				
				for (int k = i; k < arr.length; k++) {
					if (arr[k].getElement(j) != 0) {
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
				while (arr[y].getElement(j) == 0) y--;
				if (arr[x].getElement(j) == 0) {
					Vector temp = arr[x];
					arr[x] = arr[y];
					arr[y] = temp;
					
					constant *= -1;
					y--;
				}
				x++;
			}
			
			// scale for row echelon form
			constant *= 1.0 / arr[i].getElement(j);
			arr[i] = arr[i].scale (1.0 / arr[i].getElement(j));
			for (int k = i + 1; k < arr.length; k++) {
				if (arr[k].getElement(j) != 0) {
					constant *= (-1.0 / arr[k].getElement(j));
					arr[k] = arr[k].scale (- 1.0 / arr[k].getElement(j));
					
					//no modifying of x for adding
					arr[k] = arr[k].add (arr[i]);
				}
			}
			j++;
		}
		
		return constant;
	}

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