package coursera.percolation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int trials = Integer.parseInt(scanner.nextLine());

        PercolationStats stats = new PercolationStats(n, trials);

        System.out.printf("mean                    = %.16f%n", stats.mean());
        System.out.printf("stddev                  = %.16f%n", stats.stddev());
        System.out.printf("95%% confidence interval = [%.16f, %.16f]%n", stats.confidenceLo(), stats.confidenceHi());
    }
}
