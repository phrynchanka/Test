package by.epam.training.task5.dao;

public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }

    public DaoException(String mesage, Throwable cause) {
        super(mesage, cause);
    }
}
