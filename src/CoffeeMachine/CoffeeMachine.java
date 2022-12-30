package machine;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class CoffeeMachine {
// This solution uses a hashmap of ingredients for flexibility, to allow easy addition of new ingredients
// and printing of updated amounts of ingredients remaining.

    static int findMaxCups(HashMap<String, Integer> ingredients) {
        int[] maxCups = new int[3];
        int count = 0;

        // Update array with max amount of cups for each ingredient
        for (String key : ingredients.keySet()) {
            int amountLeft = ingredients.get(key);
            int amountPerCup = 1;

            switch (key) {
                case "Water":
                    amountPerCup = 200;
                    break;
                case "Milk":
                    amountPerCup = 50;
                    break;
                case "Coffee Beans":
                    amountPerCup = 15;
                    break;
                default:
                    break;
            }
            maxCups[count] = amountLeft / amountPerCup;
            count++;
        }

        // Find and return lowest amount of cups
        Arrays.sort(maxCups);
        return maxCups[0];
    }

    public static void main(String[] args) {
        HashMap<String, Integer> ingredientsLeft = new HashMap<String, Integer>();

        // Print prompts and add ingredient name and quantities to array
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        ingredientsLeft.put("Water", sc.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has: ");
        ingredientsLeft.put("Milk", sc.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        ingredientsLeft.put("Coffee Beans", sc.nextInt());
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = sc.nextInt();

        // Find max number of cups of coffee possible with ingredients
        int maxCups = findMaxCups(ingredientsLeft);
        String response;

        // Print response including number of additional cups possible
        if (maxCups > cups) {
            response = String.format("Yes, I can make that amount of coffee (and even %d more than that)", maxCups - cups);
        } else if (maxCups == cups) {
            response = "Yes, I can make that amount of coffee";
        } else {
            response = String.format("No, I can only make %d cups of coffee", maxCups);
        }
        System.out.println(response);

    }
}
