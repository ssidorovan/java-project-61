package hexlet.code;

public class Engine {


    public static int numRound = 3;
    public static int maxRandomNum = 150;

    public static void getQuestion(String value) {
        System.out.println("Question: " + value);
        System.out.print("Your answer: ");
    }

    public static void correct() {
        System.out.println("Correct!");
    }

    public static void wrong(String answerUser, String answerCorrect, String name) {
        System.out.println("'" + answerUser + "'" + " is wrong answer ;(. Correct answer was " + "'" + answerCorrect + "'.");
        System.out.println("Let's try again, " + name + "!");
    }

    public static void congratulations(String name) {
        System.out.println("Congratulations, " + name + "!");
    }

    public static int getRandomNum() {
        return (int) (Math.random() * maxRandomNum);
    }
}
