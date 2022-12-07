package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    static final int SUM_OPERATOR = 0;
    static final int DIFF_OPERATOR = 1;
    static final int MULT_OPERATOR = 2;
    static final int MAX_NUM = 3;
    static final int MIN_RANDOM = 0;
    static final int MAX_RANDOM = 150;
    static final String TASK_GAME = "What is the result of the expression?";
    public static void runGame() {
        String[][] roundsData = new String[Engine.NUM_ROUND][2];

        for (int i = 0;  i < Engine.NUM_ROUND; i++) {
            roundsData[i] = dataGame();
        }
        Engine.run(roundsData, TASK_GAME);
    }

    public static String[] dataGame() {
        int randomNum1 = Utils.generateNumber(MIN_RANDOM, MAX_RANDOM);
        int randomNum2 = Utils.generateNumber(MIN_RANDOM, MAX_RANDOM);
        String randomOperator = getRandomOperator2();
        String question = randomNum1 + " " + randomOperator + " " + randomNum2;
        String answerCorrect = test(randomNum1, randomNum2, randomOperator);

        return new String[]{question, answerCorrect};
    }

    public static String getRandomOperator2() {
        int num = Utils.generateNumber(MIN_RANDOM, MAX_NUM);

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
