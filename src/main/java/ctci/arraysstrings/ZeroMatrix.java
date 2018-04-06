package ctci.arraysstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** For each zero in the provided matrix - nullify its row and column
 *
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();

        System.out.println(Arrays.deepToString(zeroMatrix.clear(new int[][]{
                {1, 0, 3},
                {0, 5, 6},
                {5, 3, 6}
        })));
    }

    private int[][] clear(int[][] matrix) {
        Set<Integer> markedRows = new HashSet<>();
        Set<Integer> markedColumns = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j]==0){
                    markedRows.add(i);
                    markedColumns.add(j);
                }
            }
        }

        for(int row : markedRows){
            matrix[row] = new int[cols];
        }
        for(int col : markedColumns){
            for(int i=0;i<rows;i++){
                matrix[i][col] = 0;
            }
        }
        return matrix;
    }
}
