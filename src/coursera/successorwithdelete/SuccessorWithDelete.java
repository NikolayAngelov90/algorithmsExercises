package coursera.successorwithdelete;

public class SuccessorWithDelete {

    private final int[] parent;
    private final int[] max;
    private final boolean[] isRemoved;
    private final int n;

    public SuccessorWithDelete(int n) {
        this.n = n;
        parent = new int[n];
        max = new int[n];
        isRemoved = new boolean[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            max[i] = i;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        parent[rootP] = rootQ;
        max[rootQ] = Math.max(max[rootQ], max[rootP]);
    }

    public void remove(int x) {
        isRemoved[x] = true;

        if (x < n - 1 && isRemoved[x + 1]) {
            union(x, x + 1);
        }
        if (x > 0 && isRemoved[x - 1]) {
            union(x - 1, x);
        }
    }

    public int successor(int x) {
        if (x < 0 || x >= n) return -1;
        if (!isRemoved[x]) return x;

        int root = find(x);
        int succ = max[root] + 1;

        if (succ >= n) return -1;

        return succ;
    }
}
