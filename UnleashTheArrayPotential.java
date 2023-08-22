/*
 * Asked in GFG hiring challenge on 21st August 2023
 * 
 * 25 points
 * 
 * Given an array arr[], find the maximum Geek Value of the array to unleash its true potential. 
 * 
 * Geek value is defined as (arri - arrj) × arrk, where 1 ≤ i < j < k ≤ n.
 * 
 * Please note that if the Geek Value turns out to be negative, return 0 as the answer. 
 */

public class UnleashTheArrayPotential {
    public long maxValue(int n, int arr[]) {
        if (n < 3)
            return 0;
        long ans = 0;
        if (n == 3) {
            ans = (arr[0] - arr[1]) * arr[2];
            if (ans < 0)
                return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        right[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            if (arr[i] > left[i - 1])
                left[i] = arr[i];
            else
                left[i] = left[i - 1];
        }
        for (int i = n - 2; i > -1; i--) {
            if (arr[i] > right[i + 1])
                right[i] = arr[i];
            else
                right[i] = right[i + 1];
        }
        for (int i = 1; i < n - 1; i++) {
            long temp = (long) (left[i - 1] - arr[i]) * right[i + 1];
            if (temp > ans)
                ans = temp;
        }
        return ans;
    }
}
