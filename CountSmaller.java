import java.util.*;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            result.add(0);
        }
        
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        
        mergeSort(pairs, 0, n - 1, result);
        
        return result;
    }
    
    private void mergeSort(Pair[] pairs, int left, int right, List<Integer> result) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        mergeSort(pairs, left, mid, result);
        mergeSort(pairs, mid + 1, right, result);
        merge(pairs, left, mid, right, result);
    }
    
    private void merge(Pair[] pairs, int left, int mid, int right, List<Integer> result) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= right) {
            if (pairs[i].value <= pairs[j].value) {
                result.set(pairs[i].index, result.get(pairs[i].index) + (j - mid - 1));
                temp[k++] = pairs[i++];
            } else {
                temp[k++] = pairs[j++];
            }
        }
        
        while (i <= mid) {
            result.set(pairs[i].index, result.get(pairs[i].index) + (j - mid - 1));
            temp[k++] = pairs[i++];
        }
        
        while (j <= right) {
            temp[k++] = pairs[j++];
        }
        
        for (int idx = 0; idx < k; idx++) {
            pairs[left + idx] = temp[idx];
        }
    }
    
    private static class Pair {
        int value;
        int index;
        
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums1 = {5, 2, 6, 1};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + solution.countSmaller(nums1));
        
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("\nInput: " + Arrays.toString(nums2));
        System.out.println("Output: " + solution.countSmaller(nums2));
        
        int[] nums3 = {4, 3, 2, 1};
        System.out.println("\nInput: " + Arrays.toString(nums3));
        System.out.println("Output: " + solution.countSmaller(nums3));
    }
}