package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {

    static final int MIN_RANDOM = 0;
    static final int MAX_RANDOM = 150;
    static final String TASK_GAME = "Find the greatest common divisor of given numbers.";

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
        String question = randomNum1 + " "  + randomNum2;
        String answerCorrect = Integer.toString(test(randomNum1, randomNum2));

        return new String[]{question, answerCorrect};
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
