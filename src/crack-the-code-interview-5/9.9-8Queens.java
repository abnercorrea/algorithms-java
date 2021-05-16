// 8 queens problem
public class Problem9_9 {
    static int DIM = 8;
    
    private static boolean validSpot(int row, int col, int[] rows) {
        for (int i = 0; i < row; i++) {
            // check columns
            if (rows[i] == col) return false;
            
            // diagonals
            if ( (row - i) == Math.abs(col - rows[i]) ) return false;        
        }
        
        return true;    
    }
    
    private static void placeQueens(int row, int[] rows, List<int[]> solutions) {
        // CAUTION!! use row = DIM as base case.
        if (row == DIM) {
            solutions.add(rows.clone());
            
            return;
        }

        for (int col = 0; col < DIM; col++) {
            if (validSpot(row, col, rows)) {
                // place the queen
                rows[row] = col;
                placeQueens(row + 1, rows, solutions);
            }
        }
    }
    
    public static List<int[]> placeQueens() {
        List<int[]> solutions = new ArrayList<int[]>();
        
        placeQueens(0, new int[DIM], solutions);
        
        return solutions;
    }
}

// test

List<int[]> solutions = Problem9_9.placeQueens();
solutions.get(0)
int[] res1 = [0, 4, 7, 5, 2, 6, 1, 3]

0,0
1,1 0,2 2,0








// Algorithm
t = total ways to put 8 queens on a board 

t = total ways putting queen on 7, 0 + 
    total ways putting queen on 7, 1 + 
    total ways putting queen on 7, 2 + 
    total ways putting queen on 7, 3 + 
    total ways putting queen on 7, 4 + 
    total ways putting queen on 7, 5 + 
    total ways putting queen on 7, 6 + 
    total ways putting queen on 7, 7
    
total ways putting queen 8 on 7, 0 = 
    total ways putting queens on 7, 0 and 6,2 +     
    total ways putting queens on 7, 0 and 6,3 +     
    total ways putting queens on 7, 0 and 6,4 +     
    total ways putting queens on 7, 0 and 6,5 +     
    total ways putting queens on 7, 0 and 6,6 +     
    total ways putting queens on 7, 0 and 6,7 +     
6,0 and 6,1 aren't valid, since the queen would attck the queen on 7,0

positions represented by a row array, each element is the column where the queen is placed
rows[0..7]

- POSITION OF PREVIOUSLY PLACED QUEENS IS KNOWN AND VALID
- queens will be placed a row at a time, from 0 to 7
- for every new row, iterate through columns checking if it's a valid spot
- if valid spot, recurse 
    