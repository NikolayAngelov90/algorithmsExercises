package coursera.socialnetworkconnectivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<LogEntry> logs = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int type = scanner.nextInt();
            int u1 = scanner.nextInt();
            int u2 = scanner.nextInt();
            logs.add(new LogEntry(type, u1, u2));
        }

        Collections.sort(logs);

        UnionFind uf = new UnionFind(n);

        for (LogEntry log : logs) {
            if (uf.union(log.user1, log.user2)) {
                if (uf.getCount() == 1) {
                    System.out.println(log.timestamp);
                    return;
                }
            }
        }
        System.out.println("Impossible");
    }
}
