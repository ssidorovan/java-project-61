package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Prime {
    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        int count = 0;
        while (count < Engine.getNumRound()) {
            int randomNum = Engine.getRandomNum(Engine.getMinRandomNum(), Engine.getMaxRandomNum());
            String randomNumber = Integer.toString(randomNum);
            Engine.getQuestion(randomNumber);
            String answerUser = scanner.next();
            String answerCorrect = test(randomNum);

            if (answerUser.equals(answerCorrect)) {
                Engine.correct();
                count++;
            } else {
                Engine.wrong(answerUser, answerCorrect, userName);
                return;
            }
        }
        Engine.congratulations(userName);
        scanner.close();
    }

    public static String test(int number) {
        if (number < 1) {
            return "no";
        } else {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            return count == 2 ? "yes" : "no";
        }
    }
}
