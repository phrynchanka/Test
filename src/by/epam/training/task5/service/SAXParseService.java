package by.epam.training.task5.service;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.dao.implementation.SAXParseDao;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class SAXParseService implements Service {
    private final static String ATTRIBUTE = "computerList";
    private final static Logger LOGGER = Logger.getLogger(SAXParseService.class);
    @Override
    public void doService(HttpServletRequest request) throws ServiceException {
        try {
            request.setAttribute(ATTRIBUTE, SAXParseDao.getInstance().parse());
        } catch (DaoException e) {
            LOGGER.error("SAX Service exception",e);
            throw new ServiceException("SAX Service exception",e);
        }
    }
}
