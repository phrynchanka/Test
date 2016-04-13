package by.epam.training.task5.util.parser;

public enum ComputerTagEnum {
    DEVICES("devices"),
    COMPUTER("computer"),
    ID("id"),
    NAME("name"),
    ORIGIN("origin"),
    PRICE("price"),
    TYPE("type"),
    PERIPHERAL("peripheral"),
    POWER("power"),
    HARDWARE("hardware"),
    MONITOR("monitor"),
    HARDDISK("harddisk"),
    MOTHERBOARD("motherboard"),
    COOLING("cooling"),
    MOUSE("mouse"),
    KEYBOARD("keyboard"),
    PROCESSOR("processor"),
    VIDEOCARD("videocard"),
    SOCKET("socket"),
    CRITICAL("critical");
    private String value;

    private ComputerTagEnum(String mean) {
        value = mean;
    }

    public String getValue() {
        return value;
    }
}
