package by.epam.training.task5.service;

import javax.servlet.http.HttpServletRequest;

interface Service {
    void doService(HttpServletRequest request) throws ServiceException;
}
