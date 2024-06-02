/*
 * Asked in GFG hiring challenge on 21st August 2023
 * 
 * 35 points
 * 
 * Given an array, achieve the maximum possible score by removing elements from either the beginning or 
 * the end of the array. 
 * 
 * The score for removing an element is calculated as:
 * Score = element * length(arr) + minimum(arr)
 *
 */

/*
 * Always remember that when you are asked about maximizing or minimizing, then only 3 approaches
 * are there. Greedy, binary search and dp
 * 
 * Greedy approach here will not work
 * DP is the solution for this problem because we are using recursion to solve this problem
 */

public class MaximumScoreOfArray {
    public long fun(int i, int j, int[][] arr_min, int[] arr, long[][] dp) {
        if (i == j)
            return arr[i] + arr_min[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        long pick_left = (long) arr[i] * (j - i + 1) + (long) arr_min[i][j]
                + fun(i + 1, j, arr_min, arr, dp);
        long pick_right = (long) arr[j] * (j - i + 1) + (long) arr_min[i][j]
                + fun(i, j - 1, arr_min, arr, dp);
        return dp[i][j] = Math.max(pick_left, pick_right);
    }

    public long MaxScore(int N, int[] arr) {
        int[][] arr_min = new int[N][N];
        for (int i = 0; i < N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < N; j++) {
                min = Math.min(min, arr[j]);
                arr_min[i][j] = min;
            }
        }
        long[][] dp = new long[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dp[i][j] = -1;
        return fun(0, N - 1, arr_min, arr, dp);
    }
}
