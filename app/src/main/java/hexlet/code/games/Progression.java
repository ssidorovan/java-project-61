package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Progression {
    static final int MIN_LENGTH = 6;
    static final int MAX_LENGTH = 10;
    static final int MAX_STEP = 8;
    static final int MAX_START_NUM = 9;

    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        int count = 0;
        while (count < Engine.getNumRound()) {
            int[] progressionRandom = getRandomProgression();
            int elementHidden = elementRandom(progressionRandom);
            String progression = progressionWithElementHidden(progressionRandom, elementHidden);
            Engine.getQuestion(progression);
            String answerUser = scanner.next();
            String answerCorrect = Integer.toString(elementHidden);

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

    public static int[] getRandomProgression() {

        int length = Engine.getRandomNum(MIN_LENGTH, MAX_LENGTH);
        int[] arrays = new int[length];
        int step = Engine.getRandomNum(Engine.getMinRandomNum(), MAX_STEP);
        int startNum = Engine.getRandomNum(Engine.getMinRandomNum(), MAX_START_NUM);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = startNum + i * step;
        }
        return arrays;
    }

    public static int elementRandom(int[] arrays) {
        int index = Engine.getRandomNum(0, arrays.length - 1);
        return arrays[index];
    }

    public static String progressionWithElementHidden(int[] progression, int element) {
        StringBuilder result = new StringBuilder();
        for (int j : progression) {
            if (j == element) {
                result.append("..").append(" ");
            } else {
                result.append(j).append(" ");
            }
        }
        return result.toString();
    }
}
