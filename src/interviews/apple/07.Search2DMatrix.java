// Algorithm
123
456
789
- start at the top right corner
- if the START of a COLUMN is greater than x, x is to the LEFT of that column
- if the END of a LINE is lower than x, x is BELOW that line.

// matrix[line][column]
public static int[] matrixSearch(int[][] matrix, int target) {
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

// test
int[][] matrix = { {1,2,3}, {4,5,6}, {7,8,9} }

matrixSearch(matrix, 2)
matrixSearch(matrix, 90)
matrixSearch(matrix, 8)
matrixSearch(matrix, -1)
matrixSearch(null, 8)



