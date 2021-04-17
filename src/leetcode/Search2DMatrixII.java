package leetcode;

public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return false;

        int m = matrix.length, n = matrix[0].length;
        // top right
        int l = 0, c = n - 1;

        // move down and left
        while (l < m && c >= 0) {
            // CAUTION! do not forget new int[] to create array.
            if (matrix[l][c] == target) return true;

            if (matrix[l][c] > target)
                c--;
            else
                l++;
        }

        return false;
    }
}
