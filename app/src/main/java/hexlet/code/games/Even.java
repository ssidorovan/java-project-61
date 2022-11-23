package hexlet.code.games;

import hexlet.code.Greet;
import java.util.Scanner;

public class Even {
    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int count = 0;
        int numAnswerCorrect = 3;
        while (count < numAnswerCorrect) {

            int randomNumber = getRandomNumber();

            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            String answerUser = scanner.next();
            String answerCorrect = test(randomNumber);

            if (answerUser.equals(answerCorrect)) {
                System.out.println("Correct!");
                count++;
            } else {
                System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was " + "'" + answerCorrect + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
    public static int getRandomNumber() {
        int max = 10000;
        return (int) (Math.random() * max);
    }
    public static String test(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
