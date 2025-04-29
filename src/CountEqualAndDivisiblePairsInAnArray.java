import java.util.Arrays;
import java.util.Scanner;

public class CountEqualAndDivisiblePairsInAnArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(sc.nextLine());

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    int multiple = i * j;
                    if (multiple % k == 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}