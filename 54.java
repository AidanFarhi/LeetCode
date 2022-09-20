import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 54. Spiral Matrix
 * 
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int totalCells = matrix.length * matrix[0].length;
        int currentCount = 0;
        int[] positions = {0, 0};
        while (currentCount < totalCells) {
            int[] rightResult = goRight(matrix, visited, positions, output);
            currentCount += rightResult[2];
            if (currentCount == totalCells) break;
            positions[0] = rightResult[0] + 1;
            positions[1] = rightResult[1];
            int[] downResult = goDown(matrix, visited, positions, output);
            currentCount += downResult[2];
            if (currentCount == totalCells) break;
            positions[0] = downResult[0];
            positions[1] = downResult[1] - 1;
            int[] leftResult = goLeft(matrix, visited, positions, output);
            currentCount += leftResult[2];
            if (currentCount == totalCells) break;
            positions[0] = leftResult[0] - 1;
            positions[1] = leftResult[1];
            int[] upResult = goUp(matrix, visited, positions, output);
            currentCount += upResult[2];
            if (currentCount == totalCells) break;
            positions[0] = upResult[0];
            positions[1] = upResult[1] + 1;
        }
        return output;
    }
    
    public int[] goRight(int[][] matrix, Set<String> visited, int[] positions, List output) {
        int[] result = new int[3];
        int i = positions[0]; // row position
        int j = positions[1]; // col position
        int count = 1;
        for (int n = j; n < matrix[i].length; n++) {
            String pos = i + "," + n;
            if (visited.contains(pos)) {
                 return result;
            }
            result[0] = i;
            result[1] = n;
            result[2] = count;
            visited.add(pos);
            output.add(matrix[i][n]);
            count++;
        }
        return result;
    }
    
    public int[] goDown(int[][] matrix, Set<String> visited, int[] positions, List output) {
        int[] result = new int[3];
        int i = positions[0]; // row position
        int j = positions[1]; // col position
        int count = 1;
        for (int n = i; n < matrix.length; n++) {
            String pos = n + "," + j;
            if (visited.contains(pos)) {
                 return result;
            }
            result[0] = n;
            result[1] = j;
            result[2] = count;
            visited.add(pos);
            output.add(matrix[n][j]);
            count++;
        }
        return result;
    }
    
    public int[] goLeft(int[][] matrix, Set<String> visited, int[] positions, List output) {
        int[] result = new int[3];
        int i = positions[0]; // row position
        int j = positions[1]; // col position
        int count = 1;
        for (int n = j; n >= 0; n--) {
            String pos = i + "," + n;
            if (visited.contains(pos)) {
                 return result;
            }
            result[0] = i;
            result[1] = n;
            result[2] = count;
            visited.add(pos);
            output.add(matrix[i][n]);
            count++;
        }
        return result;
    }
    
    public int[] goUp(int[][] matrix, Set<String> visited, int[] positions, List output) {
        int[] result = new int[3];
        int i = positions[0]; // row position
        int j = positions[1]; // col position
        int count = 1;
        for (int n = i; n >= 0; n--) {
            String pos = n + "," + j;
            if (visited.contains(pos)) {
                 return result;
            }
            result[0] = n;
            result[1] = j;
            result[2] = count;
            visited.add(pos);
            output.add(matrix[n][j]);
            count++;
        }
        return result;
    }
}
