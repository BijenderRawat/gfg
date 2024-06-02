/*
 * Geek knows K women. 
 * Geek's neighbour has a garden in which there are N flowers and each flower has a beauty 
 * associated with it i.e. ith flower has B[i] beauty. 
 * Geek wants to pluck exactly K flowers from his neighbour's garden such that the sum of 
 * beauties of all flowers he plucked is maximum but to not get caught he can't pluck more 
 * than one flower in a row, more formally he can't pluck two flowers if they are adjacent.
 * 
 * Your task is to find maximum sum of beauty of all flowers Geek can get.
 */

class PluckingFlowers {
    public long maxBeauty(int N, int K, int[] B) {
        long[][] dp = new long[N + 1][K + 1];
        for (int i = 0; i <= N; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= K; i++)
            dp[0][i] = 0;
        dp[1][1] = B[0];
        for (int i = 2; i <= N; i++)
            dp[i][1] = Math.max(dp[i - 1][1], B[i - 1]);
        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                if (j * 2 - 1 <= i)
                    dp[i][j] = Math.max(dp[i - 1][j], B[i - 1] + dp[i - 2][j - 1]);
                else
                    dp[i][j] = 0;
            }
        }
        return dp[N][K];
    }
}
