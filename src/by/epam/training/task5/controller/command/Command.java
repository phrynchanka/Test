package by.epam.training.task5.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    void execute(HttpServletRequest request) throws CommandException;
}
