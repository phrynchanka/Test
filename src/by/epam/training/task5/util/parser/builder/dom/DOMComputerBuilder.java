package by.epam.training.task5.util.parser.builder.dom;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.entity.computer.description.TypeOfComputer;
import by.epam.training.task5.entity.computer.detail.Hardware;
import by.epam.training.task5.util.parser.builder.BaseBuilder;
import by.epam.training.task5.util.parser.ComputerTagEnum;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class DOMComputerBuilder extends BaseBuilder {
    private final static Logger LOGGER = Logger.getLogger(DOMComputerBuilder.class);

    public DOMComputerBuilder() {
        computerList = new ArrayList<Computer>();
    }

    @Override
    public void buildComputers() throws DaoException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        Document document = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
//            document = documentBuilder.parse(new InputSource(getXMLPath()));
            document = documentBuilder.parse(new InputSource(XML_PATH));
            Element root = document.getDocumentElement();

            NodeList computersList = root.getElementsByTagName(ComputerTagEnum.COMPUTER.getValue());
            for (int i = 0; i < computersList.getLength(); ++i) {
                Element computerElement = (Element) computersList.item(i);
                Computer computer = buildComputer(computerElement);
                computerList.add(computer);
            }
        } catch (ParserConfigurationException e) {
            LOGGER.error("DOM parser problem", e);
            throw new DaoException("DOM parser problem", e);
        } catch (SAXException e) {
            LOGGER.error("Input Source problem", e);
            throw new DaoException("Input Source problem", e);
        } catch (IOException e) {
            LOGGER.error("I/O excpetion", e);
            throw new DaoException("I/O excpetion", e);
        }
    }

    private Computer buildComputer(Element computerElement) {
        Computer computer = new Computer();
        TypeOfComputer typeOfComputer = computer.getType();
        Hardware hardware = typeOfComputer.getHardware();

        Element typeElement = (Element) computerElement.getElementsByTagName(ComputerTagEnum.TYPE.getValue()).item(0);
        Element hardwareElement = (Element) typeElement.getElementsByTagName(ComputerTagEnum.HARDWARE.getValue()).item(0);

        int price = Integer.parseInt(getElementText(computerElement, ComputerTagEnum.PRICE.getValue()));
        boolean critical = Boolean.valueOf(getElementText(computerElement, ComputerTagEnum.CRITICAL.getValue()));
        computer.setId(computerElement.getAttribute(ComputerTagEnum.ID.getValue()));
        computer.setName(getElementText(computerElement, ComputerTagEnum.NAME.getValue()));
        computer.setOrigin(getElementText(computerElement, ComputerTagEnum.ORIGIN.getValue()));
        computer.setPrice(price);
        computer.setCritical(critical);

        boolean peripheral = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.PERIPHERAL.getValue()));
        int power = Integer.parseInt(getElementText(typeElement, ComputerTagEnum.POWER.getValue()));
        typeOfComputer.setPeripheral(peripheral);
        typeOfComputer.setPower(power);
        boolean monitor = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.MONITOR.getValue()));
        boolean harddisk = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.HARDDISK.getValue()));
        boolean motherboard = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.MOTHERBOARD.getValue()));
        boolean cooling = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.COOLING.getValue()));
        boolean mouse = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.MOUSE.getValue()));
        boolean keyboard = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.KEYBOARD.getValue()));
        boolean processor = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.PROCESSOR.getValue()));
        boolean videocard = Boolean.valueOf(getElementText(typeElement, ComputerTagEnum.VIDEOCARD.getValue()));
        hardware.setMonitor(monitor);
        hardware.setHardDisk(harddisk);
        hardware.setMotherboard(motherboard);
        hardware.setCooling(cooling);
        hardware.setMouse(mouse);
        hardware.setKeyboard(keyboard);
        hardware.setProcessor(processor);
        hardware.setVideocard(videocard);
        hardware.setSocket(getElementText(hardwareElement, ComputerTagEnum.SOCKET.getValue()));

        return computer;
    }

    private String getElementText(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
