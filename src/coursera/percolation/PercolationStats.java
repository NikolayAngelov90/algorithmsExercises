package coursera.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int trials;
    private final double[] thresholds;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("n and trials must be greater than 0");

        this.trials = trials;
        thresholds = new double[trials];

        for (int t = 0; t < trials; t++) {
            Percolation perc = new Percolation(n);

            while (!perc.percolates()) {
                int row = StdRandom.uniformInt(n);
                int col = StdRandom.uniformInt(n);
                if (!perc.isOpen(row, col)) {
                    perc.open(row, col);
                }
            }
            thresholds[t] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(trials);
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(trials);
    }
}
