package by.epam.training.task5.service;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.implementation.StAXParseDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class StAXParseService implements Service {
    private final static String ATTRIBUTE = "computerList";
    private final static Logger LOGGER = Logger.getLogger(StAXParseService.class);
    @Override
    public void doService(HttpServletRequest request) throws ServiceException {
        try {
            request.setAttribute(ATTRIBUTE, StAXParseDao.getInstance().parse());
        } catch (DaoException e) {
            LOGGER.error("STAX Service exception",e);
            throw new ServiceException("STAX Service exception",e);
        }
    }
}
