package by.epam.training.task5.entity.computer.description;

import by.epam.training.task5.entity.computer.detail.Hardware;

public class TypeOfComputer {
    private boolean peripheral;
    private int power;
    private Hardware hardware;

    public TypeOfComputer() {
        hardware = new Hardware();
    }

    public boolean isPeripheral() {
        return peripheral;
    }

    public void setPeripheral(boolean peripheral) {
        this.peripheral = peripheral;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName());
        buffer.append("\n");
        buffer.append("peripheral: ");
        buffer.append(peripheral);
        buffer.append("\n");
        buffer.append("power: ");
        buffer.append(power);
        buffer.append("\n");
        buffer.append(hardware.toString());
        return buffer.toString();
    }
}
