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
            System.out.println( "НУ давай затестимся");
           int i = 0;
           while (i<=3) {

               System.out.println("Что такое Java?" +
                       "1. caff`e" +
                       "2. Lingua" +
                       "3. Java — строго типизированный " +
                       "объектно-ориентированный язык " +
                       "программирования общего назначения");
               int uno = input.nextInt();
               if (uno == 3) {
                   System.out.println("Что такое отладка?"+
                           "1. cloc-cloc"+
                          "2. Отладка – это процесс поиска" +
                           " и устранения ошибок в программе." +
                           "3. elif" );
                   i++;
               } else {
                   System.out.println("try again");
               }
               int due = input.nextInt();
               if (due == 2) {
                   System.out.println("Что такое алгоритм?"+
                          "1. Алгоритм – это конечный набор " +
                           "шагов, которые при следовании им решают " +
                           "какую-то задачу." +
                           "2. Jast du it"+
                           "3. ginocchio");
                   i++;
               } else {
                   System.out.println("try again");
               }
               int tre = input.nextInt();
               if (tre == 1) {
                   i++;
               } else {
                   System.out.println("try again");
               }

           }
            System.out.println("Great, you right!");
            System.out.println("Goodbye, have a nice day!");
        }
    }


