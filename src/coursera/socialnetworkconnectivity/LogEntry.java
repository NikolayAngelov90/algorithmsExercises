package coursera.socialnetworkconnectivity;

public class LogEntry implements Comparable<LogEntry> {

    int timestamp;
    int user1, user2;

    public LogEntry(int timestamp, int user1, int user2) {
        this.timestamp = timestamp;
        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public int compareTo(LogEntry other) {
        return Integer.compare(timestamp, other.timestamp);
    }
}
