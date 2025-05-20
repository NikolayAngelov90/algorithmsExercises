package coursera.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF ufPerc;
    private final WeightedQuickUnionUF ufFull;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        ufPerc = new WeightedQuickUnionUF(n * n + 2);
        ufFull = new WeightedQuickUnionUF(n * n + 1);
        virtualTop = n * n;
        virtualBottom = n * n + 1;
        openSites = 0;
    }

    public void open(int row, int col) {
        validate(row, col);

        // Convert to 0-indexed
        row--;
        col--;

        if (grid[row][col]) return;
        grid[row][col] = true;
        openSites++;

        int current = index(row, col);

        // Connect to virtual top/bottom if in the first / last row
        if (row == 0) {
            ufPerc.union(current, virtualTop);
            ufFull.union(current, virtualTop);
        }

        if (row == n - 1) {
            ufPerc.union(current, virtualBottom);
        }

        // Connect to adjacent open sites
        // Above
        if (row > 0 && grid[row - 1][col]) {
            ufPerc.union(current, index(row - 1, col));
            ufFull.union(current, index(row - 1, col));
        }

        // Below
        if (row < n - 1 && grid[row + 1][col]) {
            ufPerc.union(current, index(row + 1, col));
            ufFull.union(current, index(row + 1, col));
        }

        // Left
        if (col > 0 && grid[row][col - 1]) {
            ufPerc.union(current, index(row, col - 1));
            ufFull.union(current, index(row, col - 1));
        }
        // Right
        if (col < n - 1 && grid[row][col + 1]) {
            ufPerc.union(current, index(row, col + 1));
            ufFull.union(current, index(row, col + 1));
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) return false;

        // Convert to 0-indexed for internal calculations
        row--;
        col--;

        // Use the ufFull object to check connectivity to top without backwash
        return ufFull.find(index(row, col)) == ufFull.find(virtualTop);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        // Special case for n=1
        if (n == 1) {
            return isOpen(1, 1);
        }

        // Use ufPerc to check if virtualTop and virtualBottom are connected
        return ufPerc.find(virtualTop) == ufPerc.find(virtualBottom);
    }

    private void validate(int row, int col) {
        if (row < 1 || row > n || col < 1 || col > n) {
            throw new IllegalArgumentException("row and col must be between 1 and n");
        }
    }

    private int index(int row, int col) {
        return row * n + col;
    }
}
