package com.lukaklacar.aiengine;

import java.util.List;

public class MultiStringElement extends Element {

    private List<String> value;

    public MultiStringElement(List<String> value) {
        this.value = value;
    }

    @Override
    public int id() {
        return String.join(" ", value).hashCode();
    }
}
