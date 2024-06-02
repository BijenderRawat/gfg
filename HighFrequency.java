/*
 * You are given a string S of lowercase Latin characters with size N. 
 * Your task is to find the lexicographically smallest substring with the maximum frequency.
 */

class HighFrequency {
    public String solve(int N, String S) {
        int[] arr = new int[26];
        for (char ch : S.toCharArray())
            arr[ch - 97]++;
        int max_freq = 0;
        for (int i = 0; i < 26; i++)
            if (arr[i] > 0 && arr[i] > arr[max_freq])
                max_freq = i;
        return (char) (max_freq + 97) + "";
    }
}