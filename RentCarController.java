package by.epam.training.task6.controller;

import by.epam.training.task6.controller.command.Command;
import by.epam.training.task6.controller.command.CommandException;
import by.epam.training.task6.controller.command.CommandHelper;
import by.epam.training.task6.controller.command.implementation.PageManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RentCarController extends HttpServlet {
    private final CommandHelper commandHelper = CommandHelper.getInstance();
    private final String COMMAND_PARAMETER = "command";
    private final static String RESPONSE_TYPE_ATTRIBUTE = "responseType";
    private final String REDIRECT_PARAMETER = "redirect";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandname = request.getParameter(COMMAND_PARAMETER);
        Command command = commandHelper.defineCommand(commandname);
        System.out.println(commandname);
        try {
            String page = command.execute(request);
            String responseType = (String) request.getAttribute(RESPONSE_TYPE_ATTRIBUTE);
            if (REDIRECT_PARAMETER.equals(responseType)) {
                response.sendRedirect(getServletContext().getContextPath() + page);
            } else {
                request.getRequestDispatcher(page).forward(request, response);
            }
        } catch (CommandException e) {
            response.sendRedirect(request.getContextPath() + PageManager.getProperty(PageManager.getErrorPage()));
        }
    }
}
