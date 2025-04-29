package addTwoNumbers;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        ListNode l1 = convertToLinkedList(num1);
        ListNode l2 = convertToLinkedList(num2);

        // Показване на входните списъци
        System.out.print("Първи списък: ");
        printList(l1);
        System.out.print("Втори списък: ");
        printList(l2);

        // Събиране на числата
        ListNode result = addTwoNumbers(l1, l2);

        // Показване на резултата като списък
        System.out.print("Резултатен списък: ");
        printList(result);

        // Показване на резултата като число
        System.out.println("Резултат като число: " + convertToNumber(result));

        scanner.close();
    }

    private static long convertToNumber(ListNode head) {
        long result = 0;
        long multiplier = 1;

        ListNode current = head;
        while (current != null) {
            result += current.val * multiplier;
            multiplier *= 10;
            current = current.next;
        }

        return result;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(",");
            }
            current = current.next;
        }
        System.out.println("]");
    }

    private static ListNode convertToLinkedList(int number) {
        if (number == 0) {
            return new ListNode(0);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (number > 0) {
            current.next = new ListNode(number % 10);
            current = current.next;
            number /= 10;
        }

        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = carry + x + y;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}
