package by.epam.training.task6.controller.command;

import by.epam.training.task6.controller.command.implementation.crud.delete.DeleteCarCommandImpl;
import by.epam.training.task6.controller.command.implementation.crud.update.UpdateCarCommandImpl;
import by.epam.training.task6.controller.command.implementation.logic.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private final static CommandHelper INSTANCE = new CommandHelper();
    private Map<CommandName, Command> commandMap;

    private CommandHelper() {
        commandMap = new HashMap<CommandName, Command>();
        initCommandMap();
    }

    public static CommandHelper getInstance() {
        return INSTANCE;
    }

    public Command defineCommand(String commandStringName) {
        return commandMap.get(CommandName.valueOf(commandStringName.toUpperCase()));
    }

    private void initCommandMap() {
        //Logic
        commandMap.put(CommandName.LOGIN, new LoginCommandImpl());
        commandMap.put(CommandName.LOGOUT, new LogoutCommandImpl());
        commandMap.put(CommandName.REGISTRATION, new RegistrationCommandImpl());
        commandMap.put(CommandName.VALIDATE_INPUT_PARAMETERS, new ValidateParametersCommandImpl());
        commandMap.put(CommandName.VALIDATE_ORDER, new ValidateOrderCommandImpl());
        commandMap.put(CommandName.PAY_ORDER, new PayOrderCommandImpl());
        commandMap.put(CommandName.RECOUNT_ORDER, new RecountOrderCommandImpl());
        commandMap.put(CommandName.FINISH_ORDER, new FinishOrderCommandImpl());
        commandMap.put(CommandName.RETURN_CAR, new ReturnCarCommandImpl());
        commandMap.put(CommandName.VIEW_ALL_CAR, new ViewAllCarCommandImpl());
        commandMap.put(CommandName.ORDER_CAR, new OrderCarCommandImpl());
        commandMap.put(CommandName.VIEW_ALL_ORDER_FOR_CLIENT, new ViewAllClientOrderCommandImpl());
        commandMap.put(CommandName.VIEW_ALL_ORDER, new ViewAllOrder());
        //TODO getInstance() for commands
        //Create
        commandMap.put(CommandName.CREATE_USER, null);
        commandMap.put(CommandName.CREATE_CAR, null);
        commandMap.put(CommandName.CREATE_ORDER, null);
        commandMap.put(CommandName.CREATE_REGISTER, null);
        //Read
        commandMap.put(CommandName.SHOW_USER, null);
        commandMap.put(CommandName.SHOW_CAR, null);
        commandMap.put(CommandName.SHOW_ORDER, null);
        commandMap.put(CommandName.SHOW_REGISTER, null);
        commandMap.put(CommandName.SHOW_ALL_USERS, null);
        commandMap.put(CommandName.SHOW_ALL_CARS, null);
        commandMap.put(CommandName.SHOW_ALL_ORDERS, null);
        //Update
        commandMap.put(CommandName.UPDATE_USER, null);
        commandMap.put(CommandName.UPDATE_CAR, new UpdateCarCommandImpl());
        commandMap.put(CommandName.UPDATE_ORDER, null);
        commandMap.put(CommandName.UPDATE_REGISTER, null);
        //Delete
        commandMap.put(CommandName.DELETE_USER, null);
        commandMap.put(CommandName.DELETE_CAR, new DeleteCarCommandImpl());
        commandMap.put(CommandName.DELETE_ORDER, null);
        commandMap.put(CommandName.DELETE_REGISTER, null);
    }
}
