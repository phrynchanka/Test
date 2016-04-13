package by.epam.training.task5.util.parser;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.util.parser.builder.BaseBuilder;

import java.util.List;

public class Director {
    public static List<Computer> createComputers(BaseBuilder builder) throws DaoException {
        builder.buildComputers();
        return builder.getComputerList();
    }
}
