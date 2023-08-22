/*
 * Given an array of strings arr[]. 
 * You have to find the longest string such that also all of its prefix strings are already present 
 * in the array. 
 * If there are multiple possible strings of the same length, return the one which is lexicographically 
 * smallest.
 */

import java.util.Arrays;
import java.util.Comparator;

public class LongestString {
    public static boolean checkSubString(String[] arr, String s) {
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            boolean ispresent = false;
            for (int j = 0; j < arr.length; j++)
                if (sub.compareTo(arr[j]) == 0)
                    ispresent = true;
            if (!ispresent)
                return false;
        }
        return true;
    }

    public static String findMinString(String ans, String s) {
        if (ans == "")
            return s;
        if (ans.compareTo(s) < 0)
            return ans;
        return s;
    }

    // The function below will solve the problem in O(n^2*k) time

    // public static String longestString(String[] arr) {
    // String ans = "";
    // int maxLength = 0;
    // for (String s : arr) {
    // if (s.length() >= maxLength && checkSubString(arr, s)) {
    // if (s.length() > maxLength) {
    // maxLength = s.length();
    // ans = s;
    // } else if (s.length() == maxLength)
    // ans = findMinString(ans, s);
    // }
    // }
    // return ans;
    // }

    /*
     * The function written below to solve the problem has the time complexity of
     * O(n^2*k+nlog(n))
     * The time comparator will take to sort the array is O(nlog(n))
     * 
     * The outer loop will take O(n) time to iterate over the complete array and the
     * inner loop will
     * check for the presence of a particular substring over the complete array and
     * it would take O(n) time
     * 
     * The time complexity of the loop would be O(n*k*n) = O(n^2*k) where k is the
     * average size of the string
     * 
     * So, the overall time complexity of the whole code will become
     * O(n^2*k+nlog(n))
     * 
     */
    public static String longestString(String[] arr) {
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s2.length() - s1.length();
                } else
                    return s1.compareTo(s2);
            }
        });
        for (String word : arr) {
            boolean valid = true;
            for (int i = 1; i < word.length(); i++) {
                if (!Arrays.asList(arr).contains(word.substring(0, i))) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                return word;
        }
        return "";
    }

    public static void main(String[] args) {
        String[] arr = { "a", "ab", "abd", "abc" };
        System.out.print(longestString(arr));
    }
}