package machine;
import java.util.Scanner;
import java.util.HashMap;

public class CoffeeMachine {
    public static HashMap<String, Integer> ingredientStore = new HashMap<String, Integer>();
    public static int balance = 550;
    public static Scanner sc = new Scanner(System.in);

    static void printContents() {
        // Print current balance and amounts of ingredients stored
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", ingredientStore.get("Water"));
        System.out.printf("%d ml of milk\n", ingredientStore.get("Milk"));
        System.out.printf("%d g of coffee beans\n", ingredientStore.get("Coffee Beans"));
        System.out.printf("%d disposable cups\n", ingredientStore.get("Cups"));
        System.out.printf("$%d of money\n", balance);
    }

    static void fillMachine() {
        // Create hashmap and fill with amounts of ingredients to add from input
        HashMap<String, Integer> ingredientInput = new HashMap<String, Integer>();
        System.out.println("Write how many ml of water you want to add:");
        ingredientInput.put("Water", sc.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        ingredientInput.put("Milk", sc.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:");
        ingredientInput.put("Coffee Beans", sc.nextInt());
        System.out.println("Write how many disposable cups you want to add:");
        ingredientInput.put("Cups", sc.nextInt());

        // Increment ingredientStore values by ingredientInput values
        for (String key : ingredientStore.keySet()) {
            ingredientStore.put(key, ingredientStore.get(key) + ingredientInput.get(key));
        }
    }

    static void buyCoffee() {
        int waterRequired = 0;
        int milkRequired = 0;
        int coffeeBeansRequired = 0;
        int price = 0;
        int coffeeSelection = 0;
        boolean validInput = false;

        // Take coffee selection input until valid int in range received
        while (!validInput) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            if (sc.hasNextInt()) {
                coffeeSelection = sc.nextInt();
                if (coffeeSelection > 0 && coffeeSelection < 4) {
                    validInput = true;
                } else {
                    System.out.println("Your selection must be between 1 & 3 inclusive.");
                }
            } else {
                System.out.println("You must enter the number of your selection.");
            }
        }

        // Set ingredient amounts and price based on selection
        switch (coffeeSelection) {
            case 1:
                waterRequired = 250;
                coffeeBeansRequired = 16;
                price = 4;
                break;
            case 2:
                waterRequired = 350;
                coffeeBeansRequired = 20;
                milkRequired = 75;
                price = 7;
                break;
            case 3:
                waterRequired = 200;
                coffeeBeansRequired = 12;
                milkRequired = 100;
                price = 6;
                break;
            default:
                break;
        }

        // Decrement ingredient amounts in ingredientStore. Increment balance.
        ingredientStore.put("Water", ingredientStore.get("Water") - waterRequired);
        ingredientStore.put("Milk", ingredientStore.get("Milk") - milkRequired);
        ingredientStore.put("Coffee Beans", ingredientStore.get("Coffee Beans") - coffeeBeansRequired);
        ingredientStore.put("Cups", ingredientStore.get("Cups") - 1);
        balance += price;
    }

    static void withdrawBalance() {
        // Print balance and reduce to 0
        System.out.printf("I gave you $%d\n", balance);
        balance = 0;
    }

    public static void main(String[] args) {
        // Add starting quantities of ingredients to ingredientStore and print
        ingredientStore.put("Water", 400);
        ingredientStore.put("Milk", 540);
        ingredientStore.put("Coffee Beans", 120);
        ingredientStore.put("Cups", 9);
        printContents();

        // Prompt action selection. Store and format input.
        System.out.println("Write action (buy, fill, take):");
        String action = sc.next().toLowerCase().strip();

        // Call method for the selected action
        switch (action) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                withdrawBalance();
                break;
            default:
                System.out.println("Invalid selection");
        }

        printContents();
    }
}
