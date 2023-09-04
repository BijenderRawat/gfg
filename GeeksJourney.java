/*
 * Hard level asked in GFG hiring challenge on 21st August 2023
 * 
 * You're provided with two arrays:
 * 
 * "geeksTown" of length n - representing the heights of buildings in Geek's town
 * "journey" of length m - representing the heights of buildings he sees during his train journey.
 * 
 * Geek finds happiness when he encounters a series of buildings during his journey that 
 * completely match with geeksTown.
 * 
 * You have 'q' queries of the form [l, r], where you need to determine how many times 
 * Geek will feel happy during the journey  from [l, r].
 * 
 */

class GeeksJourney {
    public static int[] z_function(int a[], int n) {
        int z[] = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && a[r - l] == a[r])
                    r++;
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - l + 1)
                    z[i] = z[k];
                else {
                    l = i;
                    while (r < n && a[r - l] == z[r])
                        r++;
                    z[i] = r - l;
                    r--;
                }
            }
        }
        return z;
    }

    public static int[] combine(int a[], int n, int b[], int m) {
        int ans[] = new int[n + m + 1];
        for (int i = 0; i < n; i++)
            ans[i] = a[i];
        ans[n] = -1;
        for (int i = 0; i < m; i++)
            ans[i + n + 1] = b[i];
        return ans;
    }

    public static int[] geeksJourney(int geeksTown[], int n, int journey[], int m, int queries[][], int q) {
        int a[] = combine(geeksTown, n, journey, m);
        int z[] = z_function(a, a.length);
        int pre[] = new int[m];
        for (int i = n + 1; i < z.length; i++)
            if (z[i] == n)
                pre[i - n - 1] = 1;
        for (int i = 1; i < m; i++)
            pre[i] += pre[i - 1];
        int ans[] = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1] - n + 1;
            if (l > r)
                ans[i] = 0;
            else
                ans[i] = pre[r] - (l == 0 ? 0 : pre[l - 1]);
        }
        return ans;
    }
}