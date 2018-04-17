package ctci.arraysstrings;

import java.util.Arrays;

public class Q1_7_RotateMatrix {

    public static int[][] rotateMatrix(int[][] matrix) {
        int startIndex = 0;
        int endIndex = matrix.length;

        // rotate the outer frame and then move closer and closer to center
        // for each frame, go over the values and switch them around
        // value in top row goes to right column
        // value in right column goes to bottom row
        // value in bottom row goes to left column
        // value in left column goes to top row
        while(endIndex-startIndex>=2) {
            for (int i = startIndex; i < endIndex-1; i++) {
                int valueInTopRow = matrix[startIndex][i];
                int valueInRightCol = matrix[i][endIndex - 1];
                int valueInBottomRow = matrix[endIndex - 1][endIndex - 1 - i];
                int valueInLeftCol = matrix[endIndex - 1 - i][startIndex];

                matrix[startIndex][i] = valueInLeftCol;
                matrix[i][endIndex - 1] = valueInTopRow;
                matrix[endIndex - 1][endIndex - 1 - i] = valueInRightCol;
                matrix[endIndex - 1 - i][startIndex] = valueInBottomRow;
            }
            startIndex++;
            endIndex--;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {4, 3, 2, 1, 6},
                {10, 30, 50, 40, 60},
                {141, 412, 515, 51, 34},
                {352, 251, 11, 12, 14}
        };

        System.out.println(Arrays.deepToString(rotateMatrix(matrix)));
    }
}
