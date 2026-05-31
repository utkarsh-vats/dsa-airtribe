import java.util.Arrays;

public class Fibo {
    // Memoization approach
    public static int fibonacci(int x, int[] notes) {
        if (x <= 1)
            return x;
        if (notes[x] != -1)
            return notes[x];
        int ra1 = fibonacci(x - 1, notes);
        int ra2 = fibonacci(x - 2, notes);
        notes[x] = ra1 + ra2;
        return notes[x];
    }

    // Tabulation approach
    public static int fibonacci(int x) {
        int[] dp = new int[x + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x];
    }

    // leetcode #70 - Climbing Stairs
    // https://leetcode.com/problems/climbing-stairs/
    public static int climbStairs(int n) {
        // 0 - 1
        // 1 - 1
        // 2 - 2
        // 3 - 3
        // 4 - 5 (1+1+1+1) (2+2) (2+1+1) (1+2+1) (1+1+2)
        // 5 - 8
        // 6 - 13
        if (n <= 1)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // leetcode 62 - Unique Paths
    // https://leetcode.com/problems/unique-paths/
    // reccursion approach
    public static int mazePath(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc)
            return 1;
        if (sr > dr || sc > dc)
            return 0;
        int ra1 = mazePath(sr + 1, sc, dr, dc);
        int ra2 = mazePath(sr, sc + 1, dr, dc);
        return ra1 + ra2;
    }

    // memoization approach
    public static int mazePath_memo(int sr, int sc, int dr, int dc, int[][] notes) {
        if (sr == dr && sc == dc)
            return 1;
        if (sr > dr || sc > dc)
            return 0;
        if (notes[sr][sc] != -1)
            return notes[sr][sc];
        int ra1 = mazePath_memo(sr + 1, sc, dr, dc, notes);
        int ra2 = mazePath_memo(sr, sc + 1, dr, dc, notes);
        return notes[sr][sc] = ra1 + ra2;
    }

    // tabulation approach
    public static int mazePath_tab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] a : dp) {
            Arrays.fill(a, 1);
        }
        int dr = m - 1;
        int dc = n - 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[dr][dc];
    }

    // leetcode 64 - Minimum Path Sum
    // https://leetcode.com/problems/minimum-path-sum/
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0)
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                else if (j == 0)
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    // GeeksForGeeks - Gold Mine Problem
    // https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1
    public int maxGold(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int dp[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] notes = new int[8];
        Arrays.fill(notes, -1);
        System.out.println("Memoization Approach: " + fibonacci(7, notes));
        System.out.println("Tabulation Approach: " + fibonacci(7));

        int sr = 0;
        int sc = 0;
        int dr = 2;
        int dc = 2;
        int[][] path = new int[dr + 1][dc + 1];
        for (int[] a : path) {
            Arrays.fill(a, -1);
        }
        System.out.println("Maze Path: " + mazePath_memo(sr, sc, dr, dc, path));
        System.out.println("Maze Path: " + mazePath_tab(dr + 1, dc + 1));

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println("Min Path Sum: " + minPathSum(grid));
    }
}