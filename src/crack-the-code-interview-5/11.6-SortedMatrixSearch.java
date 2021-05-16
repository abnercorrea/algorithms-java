// matrix[line][column]
public static int[] matrixSearch(int[][] matrix, int x) {
    if (matrix == null) return null;
    
    int m = matrix.length, n = matrix[0].length;
    // top right
    int l = 0, c = n - 1;
    
    // move down and left
    while (l < m && c >= 0) {
        // CAUTION! do not forget new int[] to create array.
        if (matrix[l][c] == x) return new int[] { l, c };
        
        if (matrix[l][c] > x) 
            c--;
        else
            l++;
    }
    
    // CAUTION!! do not forget new int[] to create array.
    return new int[] { -1, -1 };  
 }

// test
int[][] matrix = { {1,2,3}, {4,5,6}, {7,8,9} }

matrixSearch(matrix, 2)
matrixSearch(matrix, 90)
matrixSearch(matrix, 8)
matrixSearch(matrix, -1)
matrixSearch(null, 8)



// Algorithm
123
456
789

- start at the top right corner
- if the START of a COLUMN is greater than x, x is to the LEFT of that column
- if the END of a LINE is lower than x, x is BELOW that line.