package hexlet.code;

public class Engine {
    private static final int MAX_RANDOM_NUM = 150;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int NUM_RANDOM = 3;

    public static int getMaxRandomNum() {
        return MAX_RANDOM_NUM;
    }
    public static int getMinRandomNum() {
        return MIN_RANDOM_NUM;
    }
    public static int getNumRound() {
        return NUM_RANDOM;
    }

    public static void getQuestion(String value) {
        System.out.println("Question: " + value);
        System.out.print("Your answer: ");
    }

    public static void correct() {
        System.out.println("Correct!");
    }

    public static void wrong(String answerUser, String answerCorrect, String name) {
        System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was "
                + "'" + answerCorrect + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    public static void congratulations(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static int getRandomNum(int minNum, int maxNum) {
        return (int) ((Math.random() * maxNum) + minNum);
    }
}
