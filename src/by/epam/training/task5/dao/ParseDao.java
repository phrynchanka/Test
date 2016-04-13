package by.epam.training.task5.dao;

import by.epam.training.task5.entity.computer.Computer;

import java.util.List;

public abstract class ParseDao {
    public abstract List<Computer> parse() throws DaoException;
}
