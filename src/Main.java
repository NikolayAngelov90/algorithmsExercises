import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        System.out.println(caesarCipher(s, k));

    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char asciiChar = s.charAt(i);

            if (asciiChar >= 65 && asciiChar <= 90 || asciiChar >= 97 && asciiChar <= 122) {

                int asciiSum = asciiChar + k;
                if (asciiChar <= 90) {
                    asciiChar = (char) (((asciiSum - 65) % 26) + 65);
                } else {
                    asciiChar = (char) (((asciiSum - 97) % 26) + 97);
                }

                sb.append(asciiChar);
            } else {
                sb.append(asciiChar);
            }
        }
        return sb.toString();
    }
}
