package leecode;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                char currentChar = s.charAt(j);

                if (charSet.contains(currentChar)) {
                    break;
                } else {
                    charSet.add(currentChar);
                    max = Math.max(max, j - i + 1);
                }
            }
        }

        System.out.println(max);
    }
}
