package bullscows;

import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);

    private static int bulls = 0;
    private static int cows = 0;
    private static final String CODE = "9305";

    public static void main(String[] args) {
        var guess = scan.nextLine();
        grade(guess);
        printGrade();
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
