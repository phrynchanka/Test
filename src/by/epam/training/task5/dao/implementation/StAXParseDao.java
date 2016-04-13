package by.epam.training.task5.dao.implementation;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.ParseDao;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.util.parser.Director;
import by.epam.training.task5.util.parser.builder.stax.StAXComputerBuilder;

import java.util.List;

public class StAXParseDao extends ParseDao {
    private final static StAXParseDao instance = new StAXParseDao();

    private StAXParseDao() {
    }

    public static StAXParseDao getInstance() {
        return instance;
    }

    @Override
    public List<Computer> parse() throws DaoException {
        return Director.createComputers(new StAXComputerBuilder());
    }
}
