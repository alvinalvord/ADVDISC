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
	private int rows;
	private int columns;
	
	public Matrix (int dimension) {
		vectors = new Vector[dimension];
		rows = dimension;
		columns = dimension;
		
		for (int i = 0; i < vectors.length; i++) {
			vectors[i] = new Vector (dimension);
			vectors[i].setElement (i, 1);
		}
	}
	
	public Matrix (List<Vector> list, int dimension) {
		vectors = new Vector[dimension];
		rows = dimension;
		columns = list.size ();
		
		for (int i = 0; i < dimension; i++) {
			vectors[i] = new Vector (columns);
		}
		
		for (int i = 0; i < list.size (); i++) {
			for (int j = 0; j < dimension; j++) {
				vectors[j].setElement (i, list.get (i).getElement (j));
			}
		}
	}
	
	public Matrix (Matrix matrix) {
		vectors = new Vector[matrix.rows];
		rows = matrix.rows;
		columns = matrix.columns;
		
		for (int i = 0; i < rows; i++) {
			vectors[i] = new Vector (columns);
			for (int j = 0; j < columns; j++) {
				vectors[i].setElement (j, matrix.vectors[i].getElement (j));
			}
		}
	}
	
	public Matrix times (Matrix other) {
		if (this.columns != other.rows) return null;
		
		double[][] output = new double[this.rows][other.columns];
		
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < other.columns; j++) {
				for (int k = 0; k < this.columns; k++) {
					output[i][j] += this.vectors[i].getElement (k) * other.vectors[k].getElement (j);
				}
			}
		}
		
		List<Vector> list = new ArrayList <> ();
		
		for (int i = 0; i < other.columns; i++) {
			double[] temp = new double[this.rows];
			for (int j = 0; j < this.rows; j++) {
				temp[j] = output[j][i];
			}
			list.add (new Vector (temp, this.rows));
		}
		
		Matrix outputMatrix = new Matrix (list, this.rows);
		
		return outputMatrix;
	}
	
	public Double det () {
		if (rows != columns) return null;
		
		Matrix matrix = new Matrix (this);
		Matrix inverse = new Matrix (rows);
		Vector constants = new Vector (rows);
		List<Integer> indices = new ArrayList<Integer> ();
		MutableDouble determinant = new MutableDouble (1.0);
		
		Matrix.toRowEchelon (matrix, inverse, constants, indices, determinant);
		
		if (indices.size () != rows) return new Double (0);
		
		return new Double (determinant.get ());
	}
	
	public Matrix inverse () {
		Double det = det ();
		
		if (det == null || det == 0) return null;
		
		Matrix matrix = new Matrix (this);
		Matrix inverse = new Matrix (rows);
		Vector constants = new Vector (rows);
		List<Integer> indices = new ArrayList<Integer> ();
		MutableDouble determinant = new MutableDouble (1.0);
		
		Matrix.toRowEchelon (matrix, inverse, constants, indices, determinant);
		
		Matrix.toReducedRowEchelon (matrix, inverse, constants, indices);
		
		return inverse;
	}
	
	public Matrix transpose () {
		List<Vector> list = new ArrayList<> ();
		
		for (int i = 0; i < vectors.length; i++) {
			list.add (vectors[i]);
		}
		
		return new Matrix (list, columns);
	}
	
	public Vector[] getVectors () {
		return vectors;
	}
	
	public static void toRowEchelon (Matrix matrix, Matrix inverse, Vector constants, List<Integer> indices, MutableDouble determinant) {
		
		int j = 0;
		for (int i = 0; i < matrix.rows; i++) {
			
			// search for non-zero in column
			boolean flag = false;
			
			do {
				if (j >= matrix.columns) break;
				
				for (int k = i; k < matrix.rows; k++) {
					if (matrix.vectors[k].getElement (j) != 0) {
						flag = true;
						break;
					}
				}
				
				if (!flag) j++;
			} while (!flag);
			
			if (j < matrix.columns)
				indices.add (j);
			else
				break;
			
			// sort array
			int x = i, y = matrix.rows - 1;
			
			while (x < y) {
				while (matrix.vectors[y].getElement (j) == 0) y--;
				
				if (matrix.vectors[x].getElement (j) == 0) {
					// swap matrix rows
					Vector temp = matrix.vectors[x];
					matrix.vectors[x] = matrix.vectors[y];
					matrix.vectors[y] = temp;
					
					// swap inverse rows
					temp = inverse.vectors[x];
					inverse.vectors[x] = inverse.vectors[y];
					inverse.vectors[y] = temp;
					
					// swap constants
					double tempconst = constants.getElement (x);
					constants.setElement (x, constants.getElement (y));
					constants.setElement (y, tempconst);
					
					// negate determinant
					determinant.set (-determinant.get ());
					
					y--;
				}
				x++;
			}
			
			// scale for row echelon
			double scalar = 1.0 / matrix.vectors[i].getElement (j);
			constants.setElement (i, constants.getElement (i) * (scalar));
			matrix.vectors[i] = matrix.vectors[i].scale (scalar);
			inverse.vectors[i] = inverse.vectors[i].scale (scalar);
			determinant.set (determinant.get () * scalar);
			
			// negative scale for rows below
			for (int k = i + 1; k < matrix.rows; k++) {
				if (matrix.vectors[k].getElement (j) != 0) {
					scalar = -1.0 / matrix.vectors[k].getElement (j);
					
					constants.setElement (k, constants.getElement (k) * scalar);
					matrix.vectors[k] = matrix.vectors[k].scale (scalar);
					inverse.vectors[k] = inverse.vectors[k].scale (scalar);
					determinant.set (determinant.get () * scalar);
					
					// add rows
					constants.setElement (k, constants.getElement (k) + constants.getElement (i));
					matrix.vectors[k] = matrix.vectors[k].add (matrix.vectors[i]);
					inverse.vectors[k] = inverse.vectors[k].add (inverse.vectors[i]);
				}
			}
			j++;
		}
		
	}
	
	public static void toReducedRowEchelon (Matrix matrix, Matrix inverse, Vector constants, List<Integer> indices) {
		for (int i = 1; i < indices.size (); i++) {
			int j = indices.get (i);
			
			for (int k = i - 1; k >= 0; k--) {
				Vector mtemp = new Vector (matrix.vectors[i].getElements (), matrix.columns);
				Vector itemp = new Vector (inverse.vectors[i].getElements (), inverse.columns);
				double tempconst = constants.getElement (i);
				
				double scalar = -matrix.vectors[k].getElement (j) / matrix.vectors[i].getElement (j);
				
				tempconst *= scalar;
				mtemp = mtemp.scale (scalar);
				itemp = itemp.scale (scalar);
				
				constants.setElement (k, constants.getElement (k) + tempconst);
				matrix.vectors[k] = matrix.vectors[k].add (mtemp);
				inverse.vectors[k] = inverse.vectors[k].add (itemp);
			}
		}
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		
		for (Vector v: vectors) {
			sb.append (v).append ("\n");
		}
		
		return sb.toString ();
	}
	
	public static class MutableDouble {
		private double value;
		
		public MutableDouble () {
			this (0);
		}
		
		public MutableDouble (double value) {
			set (value);
		}
		
		public void set (double value) {
			this.value = value;
		}
		
		public double get () {
			return value;
		}
	}
	
}