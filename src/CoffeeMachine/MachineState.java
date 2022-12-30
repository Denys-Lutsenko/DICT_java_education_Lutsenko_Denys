package coffeemachine;

public enum MachineState {
    AWAITING_ACTION ("Write action (buy, fill, take, remaining, exit):"),
    AWAITING_COFFEE_SELECTION ("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:"),
    AWAITING_FILL_WATER("Write how many ml of water you want to add:"),
    AWAITING_FILL_MILK ("Write how many ml of water you want to add:"),
    AWAITING_FILL_COFFEE("Write how many g of coffee you want to add:"),
    AWAITING_FILL_CUPS ("Write how many disposable cups you want to add:"),
    EXIT("");

    public final String prompt;

    private MachineState(String prompt) {
        this.prompt = prompt;
    }

}