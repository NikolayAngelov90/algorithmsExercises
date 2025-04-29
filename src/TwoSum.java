import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s++")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());

        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }

        System.out.println(Arrays.toString(indices));
    }
}
