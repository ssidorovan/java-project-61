package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Calc {
    static final int SUM_OPERATOR = 0;
    static final int DIFF_OPERATOR = 1;
    static final int MULT_OPERATOR = 2;
    static final int MAX_NUM = 3;
    public static void game() {

        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the result of the expression?");

        int count = 0;
        while (count < Engine.getNumRound()) {
            int randomNum1 = Engine.getRandomNum(Engine.getMinRandomNum(), Engine.getMaxRandomNum());
            int randomNum2 = Engine.getRandomNum(Engine.getMinRandomNum(), Engine.getMaxRandomNum());
            String randomOperator = getRandomOperator2();
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

    public static String getRandomOperator2() {
        int num = Engine.getRandomNum(Engine.getMinRandomNum(), MAX_NUM);

        return switch (num) {
            case SUM_OPERATOR -> "+";
            case DIFF_OPERATOR -> "-";
            case MULT_OPERATOR -> "*";
            default -> null;
        };
    }

    public static String test(int num1, int num2, String operator) {
        return switch (operator) {
            case "-" -> Integer.toString(num1 - num2);
            case "+" -> Integer.toString(num1 + num2);
            case "*" -> Integer.toString(num1 * num2);
            default -> null;
        };
    }
}
