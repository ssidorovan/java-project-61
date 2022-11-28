package hexlet.code.games;
import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class GCD {
    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Find the greatest common divisor of given numbers.");

        int count = 0;
        while (count < Engine.getNumRound()) {
            int randomNum1 = Engine.getRandomNum(Engine.getMinRandomNum(), Engine.getMaxRandomNum());
            int randomNum2 = Engine.getRandomNum(Engine.getMinRandomNum(), Engine.getMaxRandomNum());
            Engine.getQuestion(randomNum1 + " "  + randomNum2);
            String answerUser = scanner.next();
            String answerCorrect = Integer.toString(test(randomNum1, randomNum2));

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

    public static int test(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        } else if (num2 == 0) {
            return num1;
        } else if (num1 >= num2) {
            return test(num1 % num2, num2);
        } else {
            return test(num1, num2 % num1);
        }
    }
}
