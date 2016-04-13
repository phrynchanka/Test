package by.epam.training.task5.entity.computer.detail;

public class Hardware {
    private boolean monitor;
    private boolean hardDisk;
    private boolean motherboard;
    private boolean cooling;
    private boolean mouse;
    private boolean keyboard;
    private boolean processor;
    private boolean videocard;
    private String socket;

    public Hardware() {

    }

    public boolean isMonitor() {
        return monitor;
    }

    public void setMonitor(boolean monitor) {
        this.monitor = monitor;
    }

    public boolean isHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(boolean hardDisk) {
        this.hardDisk = hardDisk;
    }

    public boolean isMotherboard() {
        return motherboard;
    }

    public void setMotherboard(boolean motherboard) {
        this.motherboard = motherboard;
    }

    public boolean isCooling() {
        return cooling;
    }

    public void setCooling(boolean cooling) {
        this.cooling = cooling;
    }

    public boolean isMouse() {
        return mouse;
    }

    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }

    public boolean isKeyboard() {
        return keyboard;
    }

    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
    }

    public boolean isProcessor() {
        return processor;
    }

    public void setProcessor(boolean processor) {
        this.processor = processor;
    }

    public boolean isVideocard() {
        return videocard;
    }

    public void setVideocard(boolean videocard) {
        this.videocard = videocard;
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName());
        buffer.append("\n");
        buffer.append("monitor: ");
        buffer.append(monitor);
        buffer.append("\n");
        buffer.append("harddisk: ");
        buffer.append(hardDisk);
        buffer.append("\n");
        buffer.append("motherboard: ");
        buffer.append(motherboard);
        buffer.append("\n");
        buffer.append("cooling: ");
        buffer.append(cooling);
        buffer.append("\n");
        buffer.append("mouse: ");
        buffer.append(mouse);
        buffer.append("\n");
        buffer.append("keyboard: ");
        buffer.append(keyboard);
        buffer.append("\n");
        buffer.append("procesor: ");
        buffer.append(processor);
        buffer.append("\n");
        buffer.append("videocard: ");
        buffer.append(videocard);
        buffer.append("\n");
        buffer.append("socket: ");
        buffer.append(socket);
        return buffer.toString();
    }
}
