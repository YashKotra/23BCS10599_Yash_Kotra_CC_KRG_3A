import java.util.*;

public class AggressiveCows {
    public static boolean canPlace(int[] stalls, int cows, int dist) {
        int count = 1;
        int last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                count++;
                last = stalls[i];
                if (count >= cows) return true;
            }
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlace(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stalls:");
        int n = sc.nextInt();
        System.out.println("Enter number of cows:");
        int cows = sc.nextInt();
        int[] stalls = new int[n];
        System.out.println("Enter stall positions:");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }
        System.out.println("Maximum minimum distance: " + aggressiveCows(stalls, cows));
    }
}