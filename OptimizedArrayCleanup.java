import java.util.HashMap;
import java.util.Map;

public class OptimizedArrayCleanup {
    public static int minMoves(int n, int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i : arr) {
            if (!mp.containsKey(i))
                mp.put(i, 1);
            else
                mp.put(i, mp.get(i) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> m : mp.entrySet())
            max = Math.max(max, m.getValue());
        return max;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 2 };
        System.out.print(minMoves(arr.length, arr));
    }
}
