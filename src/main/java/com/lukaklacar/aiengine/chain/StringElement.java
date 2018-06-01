package com.lukaklacar.aiengine.chain;

public class StringElement extends Element {
    private String value;

    public StringElement(String value) {
        this.value = value;
    }

    @Override
    public int id() {
        return value.hashCode();
    }

    public String getValue() {
        return value;
    }
}
