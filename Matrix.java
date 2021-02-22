package assignment01;

/**
 * Represents a 2-d integer matrix as a 2-d int array.
 * 
 * @author Yifei Cao 
 *
 */
public class Matrix {
	/**
	 * Holds the number of rows of this matrix
	 */
	private int numRows;
	/**
	 * Holds the number of columns of this matrix
	 */
	private int numColumns;
	/**
	 * Holds the actual data of this matrix
	 */
	private int data[][];

	/**
	 * Constructor from a 2D array -- automatically determines the dimensions.
	 * 
	 * @param d 2D array to construct the matrix
	 * @throws IllegalArgumentException if {@code d} is empty or null
	 */
	public Matrix(int d[][]) throws IllegalArgumentException {
		if (d == null || d.length == 0) {
			throw new IllegalArgumentException();
		}
		this.numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		this.numColumns = d[0].length; // d[0] is the first 1D array

		// create a new matrix to hold the data
		this.data = new int[this.numRows][this.numColumns];
		// copy the data over
		for (int i = 0; i < this.numRows; i++) {
			for (int j = 0; j < this.numColumns; j++) {
				this.data[i][j] = d[i][j];
			}
		}
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false; 
		}
		if (!(o instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix m = (Matrix) o;// if the above was not true, we know it's safe to treat 'o' as a Matrix
		boolean a = true;
		if (this.numRows == m.numRows & this.numColumns == m.numRows) { // check if two Matrices have the same size
			for (int i = 0; i < m.numRows; i++) { // compare every data in Matrices from top left to bottom right
				for (int j = 0; j < m.numColumns; j++) {
					if (m.data[i][j] == this.data[i][j]) { // if data at the same location are different in two
															// matrices, return false
						a = false;
					}
				}
			}
		}

		return a;
	}

	@Override
	public String toString() {
		String Matrix = "";
		for (int i = 0; i < this.numRows; i++) {

			for (int j = 0; j < this.numColumns; j++) {
				Matrix += this.data[i][j] + " "; // store every data in this row to String
			}
			Matrix += "\n"; // move to next row
		}
		return Matrix;
	}

	/**
	 * Multiplies {@code this} by {@code m} and returns the result as a new
	 * {@code Matrix}. If {@code m} does not have appropriate dimensions to multiply
	 * to {@code this}, it throws an {@code IllegalArgumentException}.
	 * 
	 * @param m matrix to multiply {@code this} with
	 * @return result of the product
	 * 
	 * @throws IllegalArgumentException if dimensions of the matrices are not
	 *                                  compatible
	 */
	public Matrix times(Matrix m) throws IllegalArgumentException {
		if (this.numColumns != m.numRows) { // check if dimension of the matrices are compatible
			throw new IllegalArgumentException();
		}
		Matrix n = new Matrix(new int[this.numRows][m.numColumns]); // create the product matrix with the correct
																	// dimension
		for (int i = 0; i < this.numRows; i++) { // loop over the product
			for (int j = 0; j < m.numColumns; j++) {

				for (int p = 0; p < this.numRows; p++) { // loop over two factor matrix
					for (int q = 0; q < m.numColumns; q++) {
						n.data[i][j] += this.data[p][q] * m.data[q][p]; // multiply and store results in the product
																		// matrix
					}
				}
			}
		}
		return n;
	}

	/**
	 * Adds {@code m} to {@code this} and returns the result as a new
	 * {@code Matrix}. If {@code m} does not have the same dimensions as
	 * {@code this}, it throws an {@code IllegalArgumentException}.
	 * 
	 * @param m matrix to add to {@code this} with
	 * @return result of the addition
	 *
	 * @throws IllegalArgumentException if dimensions of the matrices are not
	 *                                  compatible
	 */
	public Matrix plus(Matrix m) throws IllegalArgumentException {

		if (m.numRows != this.numRows || m.numColumns != this.numColumns) { // check if the dimension of the matrices
																			// are the same
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < this.numRows; i++) { // loop over every data in matrix
			for (int j = 0; j < this.numColumns; j++) {
				this.data[i][j] += m.data[i][j]; // add right matrix to the left matrix and overwrite the left with the
													// result
			}
		}
		return this;
	}
}
