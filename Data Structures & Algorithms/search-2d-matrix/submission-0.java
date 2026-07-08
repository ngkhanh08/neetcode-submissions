class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;         // number of rows
        int n = matrix[0].length;      // number of columns
        
        int left = 0;
        int right = m * n - 1;         // treat 2D matrix as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];  // convert index to 2D

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
