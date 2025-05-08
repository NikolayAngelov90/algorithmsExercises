package leecode;

import java.util.*;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums1 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] nums2 = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.stream(nums1).boxed().toList());
        list.addAll(Arrays.stream(nums2).boxed().toList());

        list.sort(Integer::compareTo);

        double median;
        if (list.size() % 2 == 0) {
            median = (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.00;
        } else {
            median = list.get(list.size() / 2);
        }

        System.out.println(median);
    }
}
