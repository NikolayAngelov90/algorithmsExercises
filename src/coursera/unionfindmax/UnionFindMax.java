package coursera.unionfindmax;

public class UnionFindMax {

    private final int[] parent;
    private final int[] size;
    private final int[] max;

    public UnionFindMax(int n) {
        parent = new int[n];
        size = new int[n];
        max = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;
            max[i] = i;
        }
    }

    private int findRoot(int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            max[rootQ] = Math.max(max[rootP], max[rootQ]);
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            max[rootP] = Math.max(max[rootP], max[rootQ]);
        }
    }

    public int find(int i) {
        return max[findRoot(i)];
    }
}
