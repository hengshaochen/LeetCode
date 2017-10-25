// I
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) { return false; }
        // covert 2D index to 1D index (binary search)
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] mid_2d = convert(mid, matrix);
            if (matrix[mid_2d[0]][mid_2d[1]] == target) {
                return true;
            } else if(target > matrix[mid_2d[0]][mid_2d[1]]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    
    // ans[0]: x, ans[1]: y
    // 1D to 2D
    int[] convert(int index, int[][] matrix) {
        int[] ans = new int[2];
        
        ans[0] = index / matrix[0].length;
        ans[1] = index % matrix[0].length;
        
        return ans;
    }
}

// Template Search 2D (I)
public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) { return false; }
        // covert 2D index to 1D index (binary search)
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row * col - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid / col][mid % col] == target) {
                end = mid;
            } else if(target > matrix[mid / col][mid % col]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end / col][end % col] == target) {
            return true;
        }
        if (matrix[start / col][start % col] == target) {
            return true;
        }
        return false;
    }

}


// ---------------------
// Search 2D II
public class Solution {
    /*
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        int count = 0;
        
        while (row >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) {
                count++;
                row--;
                col++;
            } else if (target > matrix[row][col]) {
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}