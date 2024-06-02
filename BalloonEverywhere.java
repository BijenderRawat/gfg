/*
Bob is very fond of balloons. Once he visited an amusement park with his mother. 
The mother told Bob that she would buy him a balloon only if he answer her problem right. 
She gave Bob a string s and asked him to use the characters of string to form as many instances 
of the word "balloon" as possible. 
Return the maximum number of instances that can be formed.
*/
public class BalloonEverywhere {
    public static int maxInstance(String s) {
        int[] array = new int[26];
        for (char ch : s.toCharArray())
            array[ch - 97]++;
        int ans = 0;
        while (array['b' - 97] > 0 && array['a' - 97] > 0 && array['l' - 97] > 1 && array['o' - 97] > 1
                && array['n' - 97] > 0) {
            ans++;
            array['b' - 97]--;
            array['a' - 97]--;
            array['l' - 97] -= 2;
            array['o' - 97] -= 2;
            array['n' - 97]--;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "loonbalxballpoon";
        System.out.print(maxInstance(s));
    }
}