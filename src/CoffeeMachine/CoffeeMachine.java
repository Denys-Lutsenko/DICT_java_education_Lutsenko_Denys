package machine;
import java.util.Scanner;

public class CoffeeMachine {

    static int calculateQuantity(String ingredient, int cups){
        int amountPerCup = 0;
        switch (ingredient) {
            case "coffee":
                amountPerCup = 15;
                break;
            case "water":
                amountPerCup = 200;
                break;
            case "milk":
                amountPerCup = 50;
                break;
            default:
                break;
        }

        return amountPerCup * cups;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many cups of coffee would you like?");
        int cups = sc.nextInt();
        System.out.printf("For %d cups of coffee, you will need:\n", cups);
        System.out.printf("%d ml of water\n", calculateQuantity("water", cups));
        System.out.printf("%d ml of milk\n", calculateQuantity("milk", cups));
        System.out.printf("%d g of coffee beans\n", calculateQuantity("coffee", cups));
    }
}
