package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {

    static final int MIN_RANDOM = 0;
    static final int MAX_RANDOM = 150;
    static final String TASK_GAME = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void runGame() {
        String[][] roundsData = new String[Engine.NUM_ROUND][2];

        for (int i = 0;  i < Engine.NUM_ROUND; i++) {
            roundsData[i] = generateRoundData();
        }
        Engine.run(roundsData, TASK_GAME);
    }


    public static String[] generateRoundData() {
        int randomNum = Utils.generateNumber(MIN_RANDOM, MAX_RANDOM);
        String question = Integer.toString(randomNum);
        String answerCorrect = test(randomNum);

        return new String[]{question, answerCorrect};
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
