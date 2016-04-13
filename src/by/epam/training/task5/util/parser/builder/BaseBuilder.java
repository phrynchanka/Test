package by.epam.training.task5.util.parser.builder;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.entity.computer.Computer;

import java.util.List;

public abstract class BaseBuilder {
    //если путь полностью не прописать,то файл найден не будет.
    //не нашёл как это обойти. использовал InputSource.
    protected final static String XML_PATH = "E://java//projects//Task5//resource//devices.xml";

    protected List<Computer> computerList;

    public List<Computer> getComputerList() {
        return computerList;
    }

    public abstract void buildComputers() throws DaoException;

}
