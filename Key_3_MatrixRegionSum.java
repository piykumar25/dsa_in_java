public class Key_3_MatrixRegionSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] sums = precomputeSums(matrix);

        int[] A = {1, 1};  // Top-left point of the sub-matrix
        int[] D = {2, 2};  // Bottom-right point of the sub-matrix

        int result = matrixRegionSum2(matrix, A, D, sums);
        System.out.println("The sum of the sub-matrix is: " + result);  // Output should be 28
    }

    // Method to precompute the sums matrix
    public static int[][] precomputeSums(int[][] matrix) {
        int topRow = 0;
        int bottomRow = matrix.length - 1;  // The last row index
        int leftCol = 0;
        int rightCol = matrix[0].length - 1;  // The last column index

        // Initialize the sums matrix with the same size as the input matrix
        int[][] sums = new int[bottomRow - topRow + 1][rightCol - leftCol + 1];

        // Start by setting the top-left value of the sums matrix
        sums[topRow][leftCol] = matrix[topRow][leftCol];

        // Precompute the sum of the first row
        for (int col = leftCol + 1; col <= rightCol; col++) {
            sums[topRow][col] = sums[topRow][col - 1] + matrix[topRow][col];
        }

        // Precompute the sum of the first column
        for (int row = topRow + 1; row <= bottomRow; row++) {
            sums[row][leftCol] = sums[row - 1][leftCol] + matrix[row][leftCol];
        }

        // Precompute the sums for the entire matrix
        for (int col = leftCol + 1; col <= rightCol; col++) {
            int columnSum = matrix[topRow][col]; // Sum for the current column
            for (int row = topRow + 1; row <= bottomRow; row++) {
                sums[row][col] = sums[row][col - 1] + matrix[row][col] + columnSum;
                columnSum += matrix[row][col]; // Update columnSum for the next row
            }
        }

        return sums;  // Return the precomputed sums matrix
    }

    // Method to calculate the sum of the sub-matrix defined by points A and D
    public static int matrixRegionSum2(int[][] matrix, int[] A, int[] D, int[][] sums) {
        if (matrix.length == 0) {
            return 0;  // If the matrix is empty, return 0
        }

        // Calculate the necessary points (OA, OB, OC, OD) based on the conditions
        int OA = (A[0] == 0 || A[1] == 0) ? 0 : sums[A[0] - 1][A[1] - 1];
        int OC = (A[1] == 0) ? 0 : sums[D[0]][A[1] - 1];
        int OB = (A[0] == 0) ? 0 : sums[A[0] - 1][D[1]];
        int OD = sums[D[0]][D[1]];  // Sum at the bottom-right point

        // Use the inclusion-exclusion principle to get the sum of the sub-matrix
        return OD - OB - OC + OA;
    }
}