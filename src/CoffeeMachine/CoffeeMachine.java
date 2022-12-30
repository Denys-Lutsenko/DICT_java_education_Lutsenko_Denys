package machine;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Vector;

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

    static int getCoffeeSelection() {
        int coffeeSelection = 0;
        boolean validInput = false;

        // Take coffee selection input until valid int in range received
        while (!validInput) {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            String input = sc.next();
            // Return 0 if user inputs "back"
            if("back".equals(input)) {
                break;
            }
            // Check for
            try {
                coffeeSelection = Integer.parseInt(input);
                if (coffeeSelection > 0 && coffeeSelection < 4) {
                    validInput = true;
                } else {
                    System.out.println("Your selection must be between 1 & 3 inclusive.");
                    sc.next();
                }
            } catch(Exception e) {
                System.out.println("You must enter the number of your selection.");
            }
        }
        return coffeeSelection;
    }

    static void buyCoffee() {
        HashMap<String, Integer> ingredientsRequired = new HashMap<String, Integer>();
        ingredientsRequired.put("Water", 0);
        ingredientsRequired.put("Milk", 0);
        ingredientsRequired.put("Coffee Beans", 0);
        ingredientsRequired.put("Cups", 1);
        int price = 0;
        // Take coffee selection input as integer 1-3
        int coffeeSelection = getCoffeeSelection();
        if (coffeeSelection > 0) {
            // Set ingredient amounts and price based on selection
            switch (coffeeSelection) {
                case 1:
                    ingredientsRequired.put("Water", 250);
                    ingredientsRequired.put("Coffee Beans", 16);
                    price = 4;
                    break;
                case 2:
                    ingredientsRequired.put("Water", 350);
                    ingredientsRequired.put("Milk", 75);
                    ingredientsRequired.put("Coffee Beans", 20);
                    price = 7;
                    break;
                case 3:
                    ingredientsRequired.put("Water", 200);
                    ingredientsRequired.put("Milk", 100);
                    ingredientsRequired.put("Coffee Beans", 12);
                    price = 6;
                    break;
                default:
                    break;
            }

            // Set missingIngredient to ingredient name if ingredientStore value < ingredientsRequired value
            String missingIngredient = "";
            for (String key : ingredientStore.keySet()) {
                if (ingredientStore.get(key) < ingredientsRequired.get(key)) {
                    missingIngredient = key;
                }
            }

            // Decrement ingredient amounts in ingredientStore. Increment balance. Print success message
            if (missingIngredient.length() == 0) {
                for(String key : ingredientStore.keySet()) {
                    ingredientStore.put(key, ingredientStore.get(key) - ingredientsRequired.get(key));
                }
                balance += price;
                System.out.println("I have enough resources, making you a coffee!");
            } else {
                System.out.printf("Sorry, not enough %s\n", missingIngredient);
            }
        }


    }

    static void withdrawBalance() {
        // Print balance and reduce to 0
        System.out.printf("I gave you $%d\n", balance);
        balance = 0;
    }

    public static void main(String[] args) {
        // Add starting quantities of ingredients to ingredientStore
        ingredientStore.put("Water", 400);
        ingredientStore.put("Milk", 540);
        ingredientStore.put("Coffee Beans", 120);
        ingredientStore.put("Cups", 9);

        boolean machineRunning = true;
        String action;

        while(machineRunning) {
            // Prompt action selection. Store and format input.
            System.out.println("Write action (buy, fill, take):");
             action = sc.next().toLowerCase().strip();

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
                case "remaining":
                    printContents();
                    break;
                case "exit":
                    machineRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }

    }
}
