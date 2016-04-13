package by.epam.training.task5.controller.command.implementation;

import by.epam.training.task5.controller.command.Command;
import by.epam.training.task5.controller.command.CommandException;
import by.epam.training.task5.service.DOMParseService;
import by.epam.training.task5.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DOMParseCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(DOMParseCommand.class);

    @Override
    public void execute(HttpServletRequest request) throws CommandException {
        try {
            new DOMParseService().doService(request);
        } catch (ServiceException e) {
            LOGGER.error("DOM Command exception", e);
            throw new CommandException("DOM Command exception", e);
        }
    }

}
