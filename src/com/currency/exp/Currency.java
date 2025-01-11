package com.currency.exp;

import static java.lang.String.format;

public class Currency {
    private double value;
    private String name;
    private int sku;
    private Type type;
    private double actualValue;

    public Currency(double value, String name, int sku, Type type) {
        this.value = value;
        this.name = name;
        this.sku = sku;
        this.type = type;
        this.actualValue = name.equals("p") ? value / 100 : value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public double getActualValue() {
        return actualValue;
    }

    @Override
    public String toString() {
        return format("Currency{value=%s, name='%s', sku=%d, type=%s}", value, name, sku, type);
    }
}