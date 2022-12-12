package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {

    static final int MIN_RANDOM = 0;
    static final int MAX_RANDOM = 150;
    static final String TASK_GAME = "Answer 'yes' if the number is even, otherwise answer 'no'.";

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
        String answerCorrect = isEven(randomNum) ? "yes" : "no";

        return new String[]{question, answerCorrect};
    }


    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

}
