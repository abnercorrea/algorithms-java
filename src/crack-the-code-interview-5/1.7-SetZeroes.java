// time: O(m*n), space: O(m+n)
public static void setZeros(int[][] matrix) {
    if (matrix == null || matrix[0] == null) return;
    
    int m = matrix.length, n = matrix[0].length;
    Set<Integer> rows = new HashSet(), cols = new HashSet();
    
    // Needs to do this in two steps
    // 1. traverses the matrix looking for zeroes
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            if (matrix[i][j] == 0) {
                rows.add(i);
                cols.add(j);
            }
    
    // 2. sets lines and cols to zeros
    for (int row: rows)
        for (int j = 0; j < n; j++) matrix[row][j] = 0;

    for (int col: cols)
        for (int i = 0; i < m; i++) matrix[i][col] = 0;
}

int[][][] input = {
    { {2,4,5,6,0,9,6}, {3,4,6,7,1,2,6}, {1,2,3,0,8,9,8}, {9,8,7,9,4,8,7}, {3,8,7,8,7,4,0} },
    null,
    { null }
};

for (int[][] matrix: input) 
    setZeros(matrix);

2456096
3467126
1230898
9879487
3878740
m = 5
n = 7
rows = {0,2,4}
cols = {3,4,6}
[[0, 0, 0, 0, 0, 0, 0], [3, 4, 6, 0, 0, 2, 0], [0, 0, 0, 0, 0, 0, 0], [9, 8, 7, 0, 0, 8, 0], [0, 0, 0, 0, 0, 0, 0]]


