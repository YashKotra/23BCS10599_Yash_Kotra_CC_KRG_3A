import java.util.*;
class fenwickTree {
    int[] tree;
    int n;

    public fenwickTree(int size) {
        n = size;
        tree = new int[n + 1];
    }
    public void update(int idx, int val) {
        while (idx <= n) {
            tree[idx] += val;
            idx += idx & -idx;
        }
    }
    public int query(int idx) {
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx -= idx & -idx; 
        }
        return sum;
    }

    public int query(int l, int r) {
        return query(r) - query(l - 1);
    }
}