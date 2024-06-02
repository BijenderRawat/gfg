/*
 * You are given an array of n numbers and a number k. 
 * Select any two distinct indices i and j, where 1 ≤ i, j ≤ n, i != j and 
 * multiply the values at those indices by k. You need to perform this operation exactly once.
 * 
 * Determine if it is possible to perform the operation in such a way that the mean (average) of 
 * the resulting array is equal to a given value x.
 */

import java.util.HashMap;

public class WhatMeanDoYouMean {

    public static boolean isMean(int n, int k, int x, int[] arr) {
        int sum = x * n;
        for (int i : arr)
            sum -= i;
        HashMap<Integer, Boolean> mp = new HashMap<>();
        for (int i : arr) {
            if (mp.containsKey(sum - (i * (k - 1))))
                return true;
            mp.put(i * (k - 1), true);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {};
        System.out.print(isMean(arr.length, 5, 6, arr));
    }
}