package bullscows;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    private static int bulls = 0;
    private static int cows = 0;
    private static String CODE;

    public static void main(String[] args) {
        var length = scan.nextInt();
        generateCodeWithUniqueDigits(length);
        System.out.println(CODE);
//        var guess = scan.nextLine();
//        grade(guess);
//        printGrade();
    }

    private static void generateCodeWithUniqueDigits(int length) {
        if (length > 10) {
            System.out.printf("Error: can't generate a secret number with a length" +
                    " of %d because there aren't enough unique digits.\n", length);
        }
        var prn = 0L;
        while (doesNotContainEveryDigit(prn)) {
            prn = System.nanoTime();
        }
        var s = new StringBuilder();
        while (s.length() < length) {
            var digit = prn % 10;
            if (s.length() == 0 && digit == 0) {
                prn /= 10;
                continue;
            }
            s.append(digit);
            prn /= 10;
        }
        CODE = s.toString();
    }

    private static boolean doesNotContainEveryDigit(long x) {
        var s = x + "";
        for (int i = 0; i < 10; i++) {
            if (!s.contains(i + "")) {
                return true;
            }
        }
        return false;
    }

    private static void grade(String guess) {
        for (int i = 0; i < 4; i++) {
            if (CODE.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else if (CODE.contains(guess.charAt(i) + "")) {
                cows++;
            }
        }
    }

    private static void printGrade() {
        var sb = new StringBuilder("Grade: ");
        if (bulls == 0 && cows == 0) {
            sb.append("None.");
        } else if (cows == 0) {
            sb.append(bulls).append(" bull(s).");
        } else if (bulls == 0) {
            sb.append(cows).append(" cow(s).");
        } else {
            sb.append(bulls).append(" bull(s) and ").append(cows).append(" cow(s).");
        }
        sb.append(" The secret code is ").append(CODE).append('.');
        System.out.println(sb);
    }
}
