/*
 * You are given an array A.
 * In one operation, you can choose any index i such that 1 <= i <=n and Ai is even, 
 * then you can assign Ai = Ai / 2. 
 * Your task is to make total sum of array even using minimum number of operations (possibly 0) 
 * or return -1 if it is not possible.
 */

class EvenSum {
    public int findMin(int A[], int n) {
        int sum = 0;
        for (int i : A)
            sum += i;
        if (sum % 2 == 0)
            return 0;
        int ans = -1;
        for (int i : A) {
            if (i % 2 == 0) {
                int c = 0;
                while (i % 2 == 0) {
                    i /= 2;
                    c++;
                }
                if (ans == -1)
                    ans = c;
                else
                    ans = Math.min(ans, c);
            }
        }
        return ans;
    }
}