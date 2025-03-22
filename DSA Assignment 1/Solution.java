public class Solution {
    
    public static int maxIndex(int[] row, int start, int end) { //Time complexity n+2 <= 3n -> O(n)
        // Returns the index of the maximum entry between start and end
        //let n = end-start+1 (i.e. number of elements in the row we are looking at)
        int max_index=start; //Time Complexity = 1

        for(int i=start; i<=end; i++){ //Loops through each element once -> Therefore, O(n) - Time Complexity = n * 2 = 2n
            if(row[i] > row[max_index]){ //Comparision has time complexity of 1
                max_index = i; //Time complexity = 1
            };
        }

        return max_index; //Time Complexity = 1

        //Overall Time complexity = n(2) + 1 + 1 = 2n+2 <= 4n
        //Therefore, the time complexity is 4n E O(n)
    }

    public static int matrixMaxValue(int[][] matrix) {
        // Returns the maximum entry in the matrix between columns startCol, endCol inclusive and between rows startRow, endRow inclusive
        int startCol=0, startRow=0; //Time complexity = 2
        int matrix_width = matrix[0].length; //Time Complexity = 1
        int matrix_height = matrix.length; //Time complexity = 1
        return blockMaxValue(matrix, 0, 0, matrix_height-1, matrix_width-1); //Time complexity = O(mlog(n))
        //Overall complexity = 2+1+1+mlog(n) = mlog(n)+4 E O(mlog(n))
    }

    
    public static int blockMaxValue(int[][] matrix, int startRow, int startCol, int endRow, int endCol) { //Time Complexity - m (log(n) +2)? -> O(m*log(n))
        // Returns the maximum value in the matrix

        //Let m = number of columns in block Matrix (m = endCol-startCol+1)

        if (startRow > endRow || startCol > endCol) { //Check if the startRow index is less than or equal to endRow index (otherwise is an invalid array) - Same for StartCol and EndCol variables
            return Integer.MIN_VALUE; // Invalid block case
        }

        //Idea:
        //1) Find max val in middle row using maxIndex function to get its index
        //Max val in all rows above is less then or equal to index of max val in middle row
        //Max-val in all rows below is more than or equal to index of max val in middle row
        //Recursively call the blockMaxValue function with the rows above and below the central row end reduce the "Block" size by using the column index provided by the middle row
        //This performs a "Divide and Conquer" way of searching for the max value
        //Afterwards, return the maximum value found within each given row and the recursive function calls will eventually return the largest value of all rows (i.e. largest value within the "Block")

        int mid_row_index = (endRow+startRow) / 2; //Find index of middle row - O(1)

        int max_col = maxIndex(matrix[mid_row_index], startCol, endCol); //O(m) - Time complexity = 2n+2 <= 4n
        int max_value = matrix[mid_row_index][max_col]; // O(1)

        int max_lower_rows = blockMaxValue(matrix, startRow, startCol, mid_row_index-1, max_col); //Time Complexity is O(m)
        int max_upper_rows = blockMaxValue(matrix, mid_row_index+1, max_col, endRow, endCol); //Time complexity is O(m)

        //We will make log(n) recursive calls overall. Each recrusive call will perform O(m) work by calling the maxIndex function
        //Overall Complexity will be m * log(n) = O(mlog(n))

        return Math.max(max_value, Math.max(max_upper_rows, max_lower_rows)); //time complexity = 1
    }
}