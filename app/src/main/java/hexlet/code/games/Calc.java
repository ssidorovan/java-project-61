package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Calc {
    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the result of the expression?");

        int count = 0;
        while (count < Engine.numRound) {
            int randomNum1 = Engine.getRandomNum();
            int randomNum2 = Engine.getRandomNum();
            String randomOperator = getRandomOperator();
            Engine.getQuestion(randomNum1 + " " + randomOperator + " " + randomNum2);
            String answerUser = scanner.next();
            String answerCorrect = test(randomNum1, randomNum2, randomOperator);

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

    public static String getRandomOperator() {
        int num = Engine.getRandomNum();
        if (num <= 50) {
            return "-";
        } else if (num > 50 || num <= 100) {
            return "*";
        } else {
            return "-";
        }
    }

    public static String test(int num1, int num2, String operator) {
        return
        switch(operator) {
            case "-" -> Integer.toString(num1 - num2);
            case "+" -> Integer.toString(num1 + num2);
            case "*" -> Integer.toString(num1 * num2);
            default -> null;
        };
    }

}
