package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Even {
    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

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
        return number % 2 == 0 ? "yes" : "no";
    }
}
