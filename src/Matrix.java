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
	
	public double det () {
		
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder ();
		
		for (Vector v: vectors) {
			sb.append (v).append ("\n");
		}
		
		return sb.toString ();
	}
	
}