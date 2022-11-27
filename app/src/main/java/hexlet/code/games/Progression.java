package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Progression {

    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        int count = 0;
        while (count < Engine.numRound) {
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
        int length = Engine.getRandomNum(6, 10);
        int[] arrays = new int[length];
        int step = Engine.getRandomNum(2, 8);
        int startNum = Engine.getRandomNum(1, 9);
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
        String result = "";
        for (int i = 0; i < progression.length; i++) {
            if (progression[i] == element) {
                result = result + ".." + " ";
            } else {
                result = result + Integer.toString(progression[i]) + " ";
            }
        }
        return result;
    }
}
