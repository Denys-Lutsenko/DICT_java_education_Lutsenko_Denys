package coffeemachine;
import java.util.Scanner;

public class InputHandler {
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.next();
    }

    public static int getInputInt() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}