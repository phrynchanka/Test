package by.epam.training.task5.service;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.implementation.DOMParseDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class DOMParseService implements Service {
    private final static String ATTRIBUTE = "computerList";
    private final static Logger LOGGER = Logger.getLogger(DOMParseService.class);
    @Override
    public void doService(HttpServletRequest request) throws ServiceException {
        try {
            request.setAttribute(ATTRIBUTE, DOMParseDao.getInstance().parse());
        } catch (DaoException e) {
            LOGGER.error("DOM Service exception",e);
            throw new ServiceException("DOM Service exception",e);
        }
    }
}