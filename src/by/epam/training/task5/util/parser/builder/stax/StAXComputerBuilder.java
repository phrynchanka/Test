package by.epam.training.task5.util.parser.builder.stax;

import by.epam.training.task5.dao.DaoException;
import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.entity.computer.description.TypeOfComputer;
import by.epam.training.task5.entity.computer.detail.Hardware;
import by.epam.training.task5.util.parser.ComputerTagEnum;
import by.epam.training.task5.util.parser.builder.BaseBuilder;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class StAXComputerBuilder extends BaseBuilder {
    private final static Logger LOGGER= Logger.getLogger(StAXComputerBuilder.class);
    public StAXComputerBuilder() {
        computerList = new ArrayList<Computer>();
    }

    @Override
    public void buildComputers() throws DaoException {
        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
        InputStream inputStream = null;
        XMLStreamReader reader = null;
        try {
            inputStream = new FileInputStream(XML_PATH);
            reader = inputFactory.createXMLStreamReader(inputStream);
            int type;
            String tagName = null;
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        tagName = reader.getLocalName();
                        if (ComputerTagEnum.valueOf(tagName.toUpperCase()).equals(ComputerTagEnum.COMPUTER)) {
                            Computer computer = buildComputer(reader);
                            computerList.add(computer);
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("File Not Found",e);
            throw new DaoException("File Not Found", e);
        } catch (XMLStreamException e) {
            LOGGER.error("XMLStream problem",e);
            throw new DaoException("XMLStream problem", e);
        }
    }

    private Computer buildComputer(XMLStreamReader reader) throws XMLStreamException {
        Computer computer = new Computer();
        computer.setId(reader.getAttributeValue(0));
        String tagName = null;
        int type;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = reader.getLocalName();
                    switch (ComputerTagEnum.valueOf(tagName.toUpperCase())) {
                        case NAME:
                            computer.setName(getTagText(reader));
                            break;
                        case ORIGIN:
                            computer.setOrigin(getTagText(reader));
                            break;
                        case PRICE:
                            int price = Integer.parseInt(getTagText(reader));
                            computer.setPrice(price);
                            break;
                        case TYPE:
                            computer.setType(getXMLType(reader));
                            break;
                        case CRITICAL:
                            boolean critical = Boolean.valueOf(getTagText(reader));
                            computer.setCritical(critical);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    if (ComputerTagEnum.valueOf(tagName.toUpperCase()).equals(ComputerTagEnum.COMPUTER)) {
                        return computer;
                    }
                    break;
            }
        }
        return computer;
    }

    private TypeOfComputer getXMLType(XMLStreamReader reader) throws XMLStreamException {
        TypeOfComputer typeOfComputer = new TypeOfComputer();
        int type;
        String tagName;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = reader.getLocalName();
                    switch (ComputerTagEnum.valueOf(tagName.toUpperCase())) {
                        case PERIPHERAL:
                            boolean peripheral = Boolean.valueOf(getTagText(reader));
                            typeOfComputer.setPeripheral(peripheral);
                            break;
                        case POWER:
                            int power = Integer.parseInt(getTagText(reader));
                            typeOfComputer.setPower(power);
                            break;
                        case HARDWARE:
                            typeOfComputer.setHardware(getXMLHardware(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    if (ComputerTagEnum.valueOf(tagName.toUpperCase()).equals(ComputerTagEnum.TYPE)) {
                        return typeOfComputer;
                    }
                    break;
            }
        }
        return typeOfComputer;
    }

    private Hardware getXMLHardware(XMLStreamReader reader) throws XMLStreamException {
        Hardware hardware = new Hardware();
        int type;
        String tagName;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = reader.getLocalName();
                    switch (ComputerTagEnum.valueOf(tagName.toUpperCase())) {
                        case MONITOR:
                            boolean monitor = Boolean.valueOf(getTagText(reader));
                            hardware.setMonitor(monitor);
                            break;
                        case HARDDISK:
                            boolean harddisk = Boolean.valueOf(getTagText(reader));
                            hardware.setHardDisk(harddisk);
                            break;
                        case MOTHERBOARD:
                            boolean motherboard = Boolean.valueOf(getTagText(reader));
                            hardware.setMotherboard(motherboard);
                            break;
                        case COOLING:
                            boolean cooling = Boolean.valueOf(getTagText(reader));
                            hardware.setCooling(cooling);
                            break;
                        case MOUSE:
                            boolean mouse = Boolean.valueOf(getTagText(reader));
                            hardware.setMouse(mouse);
                            break;
                        case KEYBOARD:
                            boolean keyboard = Boolean.valueOf(getTagText(reader));
                            hardware.setKeyboard(keyboard);
                            break;
                        case PROCESSOR:
                            boolean processor = Boolean.valueOf(getTagText(reader));
                            hardware.setProcessor(processor);
                            break;
                        case VIDEOCARD:
                            boolean videocard = Boolean.valueOf(getTagText(reader));
                            hardware.setVideocard(videocard);
                            break;
                        case SOCKET:
                            String socket = getTagText(reader);
                            hardware.setSocket(socket);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = reader.getLocalName();
                    if (ComputerTagEnum.valueOf(tagName.toUpperCase()).equals(ComputerTagEnum.HARDWARE)) {
                        return hardware;
                    }
                    break;
            }
        }
        return hardware;
    }

    private String getTagText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

