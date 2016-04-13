package by.epam.training.task5.controller.command;

import by.epam.training.task5.controller.command.implementation.DOMParseCommand;
import by.epam.training.task5.controller.command.implementation.SAXParseCommand;
import by.epam.training.task5.controller.command.implementation.StAXParseCommand;

import java.util.HashMap;
import java.util.Map;

public class ControllerHelper {
    private Map<CommandName, Command> commands;

    public ControllerHelper() {
        commands = new HashMap<CommandName, Command>();
        commands.put(CommandName.SAX, new SAXParseCommand());
        commands.put(CommandName.STAX, new StAXParseCommand());
        commands.put(CommandName.DOM, new DOMParseCommand());
    }

    public Command getCommand(String commandName) {
        return commands.get(CommandName.valueOf(commandName.toUpperCase()));
    }
}
