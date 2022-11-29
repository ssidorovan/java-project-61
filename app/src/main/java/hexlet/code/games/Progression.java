package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Greet;
import java.util.Scanner;

public class Progression {

    static final int LENGTH_PROGRESSION = 10;
    static final int MIN_NUM = 0;
    static final int MAX_NUM = 10;

    public static void game() {
        String userName = Greet.greeting();
        Scanner scanner = new Scanner(System.in);

        System.out.println("What number is missing in the progression?");

        int count = 0;
        while (count < Engine.getNumRound()) {
            String[] progressionRandom = getRandomProgression();
            String elementHidden = elementRandom(progressionRandom);
            String progression = progressionWithElementHidden(progressionRandom, elementHidden);
            Engine.getQuestion(progression);
            String answerUser = scanner.next();
            String answerCorrect = elementHidden;

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

    public static String[] getRandomProgression() {

        String[] arrays = new String[LENGTH_PROGRESSION];
        int step = Engine.getRandomNum(MIN_NUM, MAX_NUM);
        int startNum = Engine.getRandomNum(MIN_NUM, MAX_NUM);
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = Integer.toString(startNum + i * step);
        }
        return arrays;
    }
    public static String elementRandom(String[] arrays) {
        int index = Engine.getRandomNum(0, arrays.length - 1);
        return arrays[index];
    }

    public static String progressionWithElementHidden(String[] arrays, String element) {
        String[] array = new String[arrays.length];
        for (var i = 0; i < arrays.length; i++) {
            if (arrays[i].equals(element)) {
                array[i] = "..";
            } else {
                array[i] = arrays[i];
            }
        }
        return String.join(" ", array);
    }
}
