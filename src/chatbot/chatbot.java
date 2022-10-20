package chatbot;
import java.util.Scanner;

public class chatbot {

        public static void main(String[] args) {
            System.out.println("Hello! My name is {bot_name}.");
            System.out.println( "I was created in 2020");
            System.out.println( "Please, remind me your name: ");
            Scanner input = new Scanner(System.in);
            String your_name = input.nextLine();
            System.out.println( "What a great name you have," + your_name +"!" );
            System.out.println( "Let me guess your age");
            System.out.println( "Enter remainders of dividing your age by 3, 5 and 7.");
            int remainder3 = input.nextInt();
            int remainder5 = input.nextInt();
            int remainder7 = input.nextInt();
            int your_age = (remainder3*70+remainder5*21+remainder7*15)%105;
            System.out.println( "Your age is " + your_age + " that`s a good time to start programming!");
            System.out.println( "let's count");
            int lets_count = input.nextInt();
            for ( int i = 0; i <= lets_count; i++){
            System.out.println(i+"!");
            }








        }
    }


