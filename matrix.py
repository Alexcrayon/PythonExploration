# Python Exploration
#
# It represents a 2-d integer matrix using list.
__author__ = "Yifei Cao"


class Matrix:
    def __init__(self, rows, cols, matrix):
        # store the number of rows of this matrix
        self.rows = rows
        # store the number of columns of this matrix
        self.cols = cols
        # store the data of this matrix
        self.matrix = matrix

    # Matrix addition, two matrices must have the same dimension
    def plus(self, m):
        if self.rows != m.rows or self.cols != m.cols:
            raise Exception("Matrices do not have the same dimension")

        for row in range(len(self.matrix)):
            for col in range(m.cols):
                self.matrix[row][col] += m.matrix[row][col]

        return self.matrix

    # Matrix multiplication, the first matrix must have the same number of columns as second matrix's rows
    def times(self, m):
        if self.cols != m.rows:
            raise Exception("Dimensions of matrices are not compatible")
        # The product matrix have the same number of rows as first matrix, same number of columns as second matrix
        product_matrix = create_matrix(self.rows, m.cols)
        for i in range(self.rows):
            for j in range(m.cols):
                for p in range(m.rows):
                    # doing multiplication and store result into the product matrix
                    product_matrix[i][j] += self.matrix[i][p] * m.matrix[p][j]

        return product_matrix


# Create a matrix filled with 0 with assigned size
def create_matrix(r, c):
    matrix = []
    for i in range(r):
        row = []
        for j in range(c):
            row.append(0)
        matrix.append(row)
    return matrix
