import java.io.*;

public class UniquePaths {
    private static final int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        
        if (grid[0][0] == '*' || grid[n-1][n-1] == '*') {
            System.out.println(0);
            return;
        }
        
        long[] prev = new long[n];
        long[] curr = new long[n];
        
        prev[0] = 1;
        for (int j = 1; j < n; j++) {
            if (grid[0][j] == '*') {
                prev[j] = 0;
            } else {
                prev[j] = prev[j-1];
            }
        }
        
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == '*') {
                curr[0] = 0;
            } else {
                curr[0] = prev[0];
            }
            
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == '*') {
                    curr[j] = 0;
                } else {
                    curr[j] = (curr[j-1] + prev[j]) % MOD;
                }
            }
            
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        System.out.println(prev[n-1]);
    }
}

