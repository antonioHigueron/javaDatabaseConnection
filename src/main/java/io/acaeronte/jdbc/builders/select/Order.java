package io.acaeronte.jdbc.builders.select;

public class Order {

    private final String field;
    private final OrderType type;

    public Order(String field, OrderType type) {
        this.field = field;
        this.type = type;
    }

    public String getField() {
        return field;
    }

    public OrderType getType() {
        return type;
    }
}
