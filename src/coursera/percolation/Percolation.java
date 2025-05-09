package coursera.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF uf;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2);
        virtualTop = n * n;
        virtualBottom = n * n + 1;
        openSites = 0;
    }

    public void open(int row, int col) {
        validate(row, col);
        if (grid[row][col]) return;
        grid[row][col] = true;
        openSites++;

        int current = index(row, col);

        if (row == 0) uf.union(current, virtualTop);
        if (row == n - 1) uf.union(current, virtualBottom);

        if (row > 0 && isOpen(row - 1, col)) uf.union(current, index(row - 1, col));
        if (row < n - 1 && isOpen(row + 1, col)) uf.union(current, index(row + 1, col));
        if (col > 0 && isOpen(row, col - 1)) uf.union(current, index(row, col - 1));
        if (col < n - 1 && isOpen(row, col + 1)) uf.union(current, index(row, col + 1));
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row][col];
    }

    public boolean isFull(int row, int col) {
        return isOpen(row, col) && uf.find(index(row, col)) == uf.find(virtualTop);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    private void validate(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n) {
            throw new IllegalArgumentException("row and col must be in range [0, n)");
        }
    }

    private int index(int row, int col) {
        return row * n + col;
    }
}
