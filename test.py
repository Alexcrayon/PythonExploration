from matrix import Matrix


# print each row of the matrix on a new line
def format_matrix(m):
    for i in range(len(m)):
        print(m[i])
    print()


matrix1 = Matrix(2, 3, [[1, 2, 4], [3, 5, 4]])

matrix2 = Matrix(2, 3, [[3, 4, 5], [7, 8, 9]])

matrix3 = Matrix(3, 2, [[4, 5], [7, 8], [1, 2]])

format_matrix(matrix1.times(matrix3))

format_matrix(matrix1.plus(matrix2))
