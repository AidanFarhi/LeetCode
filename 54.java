import java.util.LinkedList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new LinkedList<>();
        int rowTop = 0;
        int rowBottom = matrix.length - 1;
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int terminate = matrix.length * matrix[0].length;
        
        while (result.size() < terminate) {
            
            // traverse right
            for (int i = colLeft; i <= colRight && result.size() < terminate; i++) {
                result.add(matrix[rowTop][i]);
            }
            rowTop++;
            
            // traverse down
            for (int i = rowTop; i <= rowBottom && result.size() < terminate; i++) {
                result.add(matrix[i][colRight]);
            }
            colRight--;
            
            // traverse left
            for (int i = colRight; i >= colLeft && result.size() < terminate; i--) {
                result.add(matrix[rowBottom][i]);
            }
            rowBottom--;
            
            // traverse up
            for (int i = rowBottom; i >= rowTop && result.size() < terminate; i--) {
                result.add(matrix[i][colLeft]);
            }
            colLeft++;
        }
        return result;
    }
}
