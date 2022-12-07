package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    static final int MIN_LENGTH = 6;
    static final int MAX_LENGTH = 10;
    static final int MIN_NUM = 0;
    static final int MAX_NUM = 10;

    static final String TASK_GAME = "What number is missing in the progression?";

    public static void runGame() {
        String[][] roundsData = new String[Engine.NUM_ROUND][2];
        for (int i = 0;  i < Engine.NUM_ROUND; i++) {
            roundsData[i] = dataGame();
        }
        Engine.run(roundsData, TASK_GAME);
    }

    public static String[] dataGame() {
        int[] progressionRandom = getRandomProgression();
        int elementHidden = elementRandom(progressionRandom);
        String progression = progressionWithElementHidden(progressionRandom, elementHidden);
        String question = progression;
        String answerCorrect = Integer.toString(elementHidden);

        return new String[]{question, answerCorrect};
    }

    public static int[] getRandomProgression() {

        int length = Utils.generateNumber(MIN_LENGTH, MAX_LENGTH);
        int[] arrays = new int[length];
        int step = Utils.generateNumber(MIN_NUM, MAX_NUM);
        int startNum = Utils.generateNumber(MIN_NUM, MAX_NUM);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = startNum + i * step;
        }
        return arrays;
    }

    public static int elementRandom(int[] arrays) {
        int index = Utils.generateNumber(0, arrays.length - 1);
        return arrays[index];
    }

    public static String progressionWithElementHidden(int[] progression, int element) {
        StringBuilder result = new StringBuilder();
        for (int i : progression) {
            if (i == element) {
                result.append("..").append(" ");
            } else {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }
}
