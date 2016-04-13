package by.epam.training.task5.controller.command.implementation;

import by.epam.training.task5.controller.command.Command;
import by.epam.training.task5.controller.command.CommandException;
import by.epam.training.task5.service.SAXParseService;
import by.epam.training.task5.service.ServiceException;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SAXParseCommand implements Command {
    private final static Logger LOGGER = Logger.getLogger(SAXParseCommand.class);
    @Override
    public void execute(HttpServletRequest request) throws CommandException {
        try {
            new SAXParseService().doService(request);
        } catch (ServiceException e) {
            LOGGER.error("SAX Command exception",e);
            throw new CommandException("SAX Command exception",e);
        }
    }
}
