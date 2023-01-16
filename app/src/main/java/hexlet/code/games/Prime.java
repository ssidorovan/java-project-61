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
        String answerCorrect = isPrime(randomNum) ? "yes" : "no";

        return new String[]{question, answerCorrect};
    }


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
