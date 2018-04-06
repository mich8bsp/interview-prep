package leetcode;

import java.util.PriorityQueue;

/**
 * Created by U43155 on 18/03/2018.
 *
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.
 Note:
 You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 */
public class Prob378_medium {

    private static class ValWithIndex implements Comparable<ValWithIndex>{
        public int value;
        public int row;
        public int col;

        public ValWithIndex(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(ValWithIndex o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<ValWithIndex> minHeap = new PriorityQueue<>();
        minHeap.add(new ValWithIndex(matrix[0][0], 0, 0));
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] added = new int[rows][cols];
        added[0][0]=1;
        while(k>0){
            ValWithIndex currPolled = minHeap.poll();
            if(--k==0){
                return currPolled.value;
            }
            int i = currPolled.row;
            int j = currPolled.col;
            if(j<matrix[i].length-1 && added[i][j+1]==0) {
                added[i][j+1] = 1;
                minHeap.add(new ValWithIndex(matrix[i][j+1], i, j+1));
            }
            if(i<matrix.length-1 && added[i+1][j]==0){
                added[i+1][j] = 1;
                minHeap.add(new ValWithIndex(matrix[i+1][j], i+1, j));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Prob378_medium prob = new Prob378_medium();
        //[[1,3,5],[6,7,12],[11,14,14]]
        int[][] matrix = new int[][]{
                {1,3,5},
                {6, 7, 12},
                {11, 14, 14}};



        int res = prob.kthSmallest(matrix, 6);

        System.out.println(res); // 13
    }

}
