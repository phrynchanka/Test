package by.epam.training.task5.util.parser.builder.sax;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.util.parser.builder.BaseBuilder;
import by.epam.training.task5.util.parser.builder.sax.handler.ComputerHandler;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXComputerBuilder extends BaseBuilder {
    private final static Logger LOGGER = Logger.getLogger(SAXComputerBuilder.class);

    public SAXComputerBuilder() {
    }

    @Override
    public void buildComputers() throws DaoException {
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            ComputerHandler computerHandler = new ComputerHandler();
            xmlReader.setContentHandler(computerHandler);
            xmlReader.parse(new InputSource(XML_PATH));
            computerList = computerHandler.getComputerList();
        } catch (SAXException e) {
            LOGGER.error("Sax parse exception", e);
            throw new DaoException("Sax parse exception", e);
        } catch (IOException e) {
            LOGGER.error("I/O exception", e);
            throw new DaoException("I/O exception", e);
        }
    }
}
