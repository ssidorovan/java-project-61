package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {

    static final int MIN_RANDOM = 0;
    static final int MAX_RANDOM = 150;
    static final String TASK_GAME = "What is the result of the expression?";

    public static void runGame() {
        String[][] roundsData = new String[Engine.NUM_ROUND][2];

        for (int i = 0;  i < Engine.NUM_ROUND; i++) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(roundsData, TASK_GAME);
    }


    public static String[] generateRoundData() {
        int randomNum1 = Utils.generateNumber(MIN_RANDOM, MAX_RANDOM);
        int randomNum2 = Utils.generateNumber(MIN_RANDOM, MAX_RANDOM);
        String randomOperator = getRandomOperator();
        String question = randomNum1 + " " + randomOperator + " " + randomNum2;
        String answerCorrect = calculate(randomNum1, randomNum2, randomOperator);

        return new String[]{question, answerCorrect};
    }


    public static String getRandomOperator() {
        String[] operators = {"-", "+", "*"};
        int i = Utils.generateNumber(0, operators.length - 1);
        return operators[i];
    }


    public static String calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "-" -> Integer.toString(num1 - num2);
            case "+" -> Integer.toString(num1 + num2);
            case "*" -> Integer.toString(num1 * num2);
            default -> null;
        };
    }
}
