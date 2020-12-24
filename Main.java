package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    private static int bulls = 0;
    private static int cows = 0;
    private static String CODE;
    private static boolean guessed = false;
    private static char[] symbols = new char[36];

    public static void main(String[] args) {
        fillSymbols();
        System.out.println("Input the length of the secret code:");
        var length = scan.nextInt();
        System.out.println("Input the number of possible symbols in the code:");
        var numOfSymbols = scan.nextInt();
        scan.nextLine();

        if (length > 36) {
            System.out.printf("Error: can't generate a secret code with a length" +
                    " of %d because there aren't enough unique symbols.\n", length);
            return;
        }
        var range = makeRangeString(numOfSymbols);
        generateCodeWithUniqueSymbols(length, numOfSymbols);
        System.out.println("The secret code is prepared: " +
                "*".repeat(length) + range);

        System.out.println("Okay, let's start a game!");

        var count = 1;
        while (!guessed) {
            System.out.printf("Turn %d:\n", count++);
            var guess = scan.nextLine();
            grade(guess);
            printGrade();
        }

        System.out.println("Congratulations! You guessed the secret code.");
    }

    private static void generateCodeWithUniqueSymbols(int length, int numOfSymbols) {
        var sb = new StringBuilder();
        new Random().ints(0, numOfSymbols)
                .distinct()
                .limit(length)
                .forEach(x -> sb.append(symbols[x]));
        CODE = sb.toString();
    }

    private static void grade(String guess) {
        if (guess.length() == CODE.length()) {
            for (int i = 0; i < CODE.length(); i++) {
                if (CODE.charAt(i) == guess.charAt(i)) {
                    bulls++;
                } else if (CODE.contains(guess.charAt(i) + "")) {
                    cows++;
                }
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
        System.out.println(sb);
        if (bulls == CODE.length()) {
            guessed = true;
        }
        bulls = 0;
        cows = 0;
    }

    private static void fillSymbols() {
        char num = '0';
        char c = 'a';
        for (int i = 0; i < 10; i++) {
            symbols[i] = num++;
        }
        for (int i = 10; i < 36; i++) {
            symbols[i] = c++;
        }
    }

    private static String makeRangeString(int num) {
        var sb = new StringBuilder(" (");
        if (num <= 10) {
            sb.append("0-").append(symbols[num - 1]);
        } else {
            sb.append("0-9, a-").append(symbols[num - 1]);
        }

        sb.append(").");
        return sb.toString();
    }
}
