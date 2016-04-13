package by.epam.training.task5.dao.implementation;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.ParseDao;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.util.parser.Director;
import by.epam.training.task5.util.parser.builder.dom.DOMComputerBuilder;

import java.util.List;

public class DOMParseDao extends ParseDao {
    private final static DOMParseDao instance = new DOMParseDao();

    private DOMParseDao() {
    }

    public static DOMParseDao getInstance() {
        return instance;
    }

    @Override
    public List<Computer> parse() throws DaoException {
        return Director.createComputers(new DOMComputerBuilder());
    }
}
