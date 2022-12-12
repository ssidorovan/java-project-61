package hexlet.code;

public class Utils {

    public static int generateNumber(int min, int max) {
        return  min + (int) (Math.random() * (max - min));
    }
}
