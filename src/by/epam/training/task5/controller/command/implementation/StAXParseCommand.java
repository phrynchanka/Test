package by.epam.training.task5.controller.command.implementation;

import by.epam.training.task5.controller.command.Command;
import by.epam.training.task5.controller.command.CommandException;
import by.epam.training.task5.service.ServiceException;
import by.epam.training.task5.service.StAXParseService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class StAXParseCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(StAXParseCommand.class);

    @Override
    public void execute(HttpServletRequest request) throws CommandException {
        try {
            new StAXParseService().doService(request);
        } catch (ServiceException e) {
            LOGGER.error("STAX Command exception", e);
            throw new CommandException("STAX Command exception", e);
        }
    }
}
