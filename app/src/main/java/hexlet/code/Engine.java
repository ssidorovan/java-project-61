package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static final int NUM_ROUND = 3;

    public static void run(String[][] roundsData, String taskGame) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(taskGame);

        for (var roundData : roundsData) {
            String question = roundData[0];
            String answerCorrect = roundData[1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String answerUser = scanner.next();

            if (answerUser.equals(answerCorrect)) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + answerCorrect + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
