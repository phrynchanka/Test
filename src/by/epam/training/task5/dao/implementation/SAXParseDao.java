package by.epam.training.task5.dao.implementation;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.ParseDao;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.util.parser.Director;
import by.epam.training.task5.util.parser.builder.sax.SAXComputerBuilder;

import java.util.List;

public class SAXParseDao extends ParseDao {
    private final static SAXParseDao instance = new SAXParseDao();

    private SAXParseDao() {
    }

    public static SAXParseDao getInstance() {
        return instance;
    }

    @Override
    public List<Computer> parse() throws DaoException {
        return Director.createComputers(new SAXComputerBuilder());
    }
}
