package by.epam.training.task5.controller;

import by.epam.training.task5.controller.command.CommandException;
import by.epam.training.task5.controller.command.ControllerHelper;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class XMLController extends HttpServlet {
    private final static Logger LOGGER = Logger.getLogger(XMLController.class);
    private ControllerHelper controllerHelper;
    private final String RESULT_PAGE = "/result.jsp";
    private final String ERROR_PAGE = "/error.jsp";
    private final String INPUT_PARAMETER = "command";

    public XMLController() {
        super();
        controllerHelper = new ControllerHelper();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(INPUT_PARAMETER);
        try {
            controllerHelper.getCommand(commandName).execute(request);
            request.getRequestDispatcher(RESULT_PAGE).forward(request, response);
        } catch (CommandException e) {
            LOGGER.error("Controller exception", e);
            request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
