package by.epam.training.task5.entity.computer;

import by.epam.training.task5.entity.computer.description.TypeOfComputer;

public class Computer {
    private String id;
    private String name;
    private String origin;
    private int price;
    private TypeOfComputer type;
    private boolean critical;

    public Computer() {
        type = new TypeOfComputer();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TypeOfComputer getType() {
        return type;
    }

    public void setType(TypeOfComputer type) {
        this.type = type;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName());
        buffer.append(": ");
        buffer.append("id = ");
        buffer.append(id);
        buffer.append("\n");
        buffer.append("name: ");
        buffer.append(name);
        buffer.append("\n");
        buffer.append("origin: ");
        buffer.append(origin);
        buffer.append("\n");
        buffer.append("price: ");
        buffer.append(price);
        buffer.append("\n");
        buffer.append("type");
        buffer.append(type.toString());
        buffer.append("\n");
        buffer.append("critical: ");
        buffer.append(critical);
        buffer.append("\n");
        return buffer.toString();
    }
}
