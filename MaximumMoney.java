/* You have M rupees. 
  you are given the cost of a gold coin, silver coin and bronze coin in Bangalore and Ahmedabad in arrays B and A respectively. 
  You can buy at most one type of coin in Bangalore according to your money and sell them in Ahmedabad. 
  You have to return the maximum money you can have in Ahmedabad. */

class MaximumMoney {
    public int MaxMoney(int M, int[] B, int[] A) {
        int max = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[i] >= B[i]) {
                int coins = M / B[i];
                int remainingmoney = M % B[i];
                max = Math.max(max, coins * A[i] + remainingmoney);
            } else {
                int remainingmoney = M - B[i];
                max = Math.max(max, Math.max(1 * A[i] + remainingmoney, M));
            }
        }
        return max;
    }
}