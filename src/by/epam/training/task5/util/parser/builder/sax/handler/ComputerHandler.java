package by.epam.training.task5.util.parser.builder.sax.handler;

import by.epam.training.task5.entity.computer.Computer;
import by.epam.training.task5.util.parser.ComputerTagEnum;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ComputerHandler extends DefaultHandler {
    private List<Computer> computerList;
    private Computer computer;
    private StringBuilder text;

    public ComputerHandler() {
        computerList = new ArrayList<Computer>();
        computer = null;
        text = null;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        text = new StringBuilder();
        if (localName.equals(ComputerTagEnum.COMPUTER.getValue())) {
            computer = new Computer();
            computer.setId(attributes.getValue(ComputerTagEnum.ID.getValue()));
        }
    }

    public void endElement(String uri, String localName, String qName) {
        ComputerTagEnum tag = ComputerTagEnum.valueOf(localName.toUpperCase());
        switch (tag) {
            case NAME:
                computer.setName(text.toString());
                break;
            case ORIGIN:
                computer.setOrigin(text.toString());
                break;
            case PRICE:
                computer.setPrice(Integer.parseInt(text.toString()));
                break;
            case PERIPHERAL:
                computer.getType().setPeripheral(Boolean.valueOf(text.toString()));
                break;
            case POWER:
                computer.getType().setPower(Integer.parseInt(text.toString()));
                break;
            case MONITOR:
                computer.getType().getHardware().setMonitor(Boolean.valueOf(text.toString()));
                break;
            case HARDDISK:
                computer.getType().getHardware().setHardDisk(Boolean.valueOf(text.toString()));
                break;
            case MOTHERBOARD:
                computer.getType().getHardware().setMotherboard(Boolean.valueOf(text.toString()));
                break;
            case COOLING:
                computer.getType().getHardware().setCooling(Boolean.valueOf(text.toString()));
                break;
            case MOUSE:
                computer.getType().getHardware().setMouse(Boolean.valueOf(text.toString()));
                break;
            case KEYBOARD:
                computer.getType().getHardware().setKeyboard(Boolean.valueOf(text.toString()));
                break;
            case PROCESSOR:
                computer.getType().getHardware().setProcessor(Boolean.valueOf(text.toString()));
                break;
            case VIDEOCARD:
                computer.getType().getHardware().setVideocard(Boolean.valueOf(text.toString()));
                break;
            case SOCKET:
                computer.getType().getHardware().setSocket(text.toString());
                break;
            case CRITICAL:
                computer.setCritical(Boolean.valueOf(text.toString()));
                break;
            case COMPUTER:
                computerList.add(computer);
                computer = null;
                break;
        }
    }

    public void characters(char[] buffer, int start, int end) {
        text.append(buffer, start, end);
    }

    public List<Computer> getComputerList() {
        return computerList;
    }

}
