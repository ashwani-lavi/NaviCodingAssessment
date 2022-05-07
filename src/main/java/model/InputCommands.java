package model;

public enum InputCommands {
    LOAN("LOAN"),
    PAYMENT("PAYMENT"),
    BALANCE("BALANCE");

    private final String inputCommand;

    InputCommands(String inputCommand) {
        this.inputCommand = inputCommand;
    }

    public String getInputCommand() {
        return inputCommand;
    }
}
