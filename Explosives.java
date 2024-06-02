/*
 * Geek is fond of explosives. 
 * He has lined up a row of N boxes containing explosives in his garden. 
 * The boxes are of K different colours. The ith box is of colour col[i]. 
 * If three or more boxes of similar colour occur together, 
 * all of them will explode without affecting their neighboring boxes which are not of the 
 * same colour.
 * 
 * In the initial arrangement of the boxes, no three boxes of the same colour will occur together. 
 * Geek has an extra box with him of colour C. 
 * He can insert that box between any two boxes in the row to set off the explosion. 
 * Help geek find the maximum number of boxes can be explode. 
 * 
 * Note: The extra box inserted by Geek is not counted in the final answer.
 */

class Explosives {
    public int maxBoxes(int n, int k, int c, int[] col) {
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (col[i] == col[i + 1] && col[i] == c) {
                int sum = 2;
                int left = i - 1;
                int right = i + 2;
                while (left > -1 && right < n && col[left] == col[right]) {
                    int count = 2;
                    left--;
                    right++;
                    if (left > -1 && col[left] == col[left + 1]) {
                        left--;
                        count++;
                    }
                    if (right < n && col[right] == col[right - 1]) {
                        right++;
                        count++;
                    }
                    if (count > 2)
                        sum += count;
                    else
                        break;
                }
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
}