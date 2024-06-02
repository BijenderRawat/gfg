import java.util.HashMap;

public class DistinctArrayOptimization {
    public static int arrayOptimization(int n, int[] arr) {
        int l = 0, r = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        while (r < n) {
            if (!mp.containsKey(arr[r]))
                mp.put(arr[r], 1);
            else
                mp.put(arr[r], mp.get(arr[r]) + 1);
            while (l <= r && mp.get(arr[r]) > 1) {
                mp.put(arr[l], mp.get(arr[l]) - 1);
                l++;
            }
            ans = Math.min(ans, Math.min(2 * l + n - 1 - r, l + (n - 1 - r) * 2));
            r++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 1 };
        System.out.print(arrayOptimization(arr.length, arr));
    }
}