import java.util.ArrayList;
import java.util.List;

/*
 * You are given 2 integers, l and r. You have to find all the perfect palindrome integers in this range
 * where l and r are inclusive. 
 * 
 * Perfect Palindrome means is number is palindrome + there exists a number n in this range for which
 * there exists a number k such that k * k == n
 * 
 */

class SuperPalindrome {
    public static void perfectSquare(int l, int r, List<Integer> list) {
        int n = (int) Math.sqrt(l);
        int temp = n * n;
        while (temp < l || temp >= l && temp <= r) {
            if (temp < l) {
                n++;
                continue;
            }
            list.add(temp);
            n++;
        }
    }

    public static boolean check(int i) {
        int temp = i;
        int ans = 0;
        while (i != 0) {
            ans = ans * 10 + i % 10;
            i /= 10;
        }
        if (ans == temp)
            return true;
        return false;
    }

    public static int checkPalindrome(List<Integer> list) {
        int ans = 0;
        for (int i : list) {
            if (check(i)) {
                ans++;
            }
        }
        return ans;
    }

    public static int countSuperPalindrome(int l, int r) {
        List<Integer> list = new ArrayList<>();
        perfectSquare(l, r, list);
        return checkPalindrome(list);
    }
}