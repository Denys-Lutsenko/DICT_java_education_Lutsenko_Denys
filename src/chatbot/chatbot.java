package chatbot;
import java.util.Scanner;

public class chatbot {

        public static void main(String[] args) {
            System.out.println("Hello! My name is {bot_name}.");
            System.out.println( "I was created in 2020");
            System.out.println( "Please, remind me your name: ");
            Scanner input = new Scanner(System.in);
            String your_name = input.next();
            System.out.println( "What a great name you have," + your_name +"!" );






        }
    }


