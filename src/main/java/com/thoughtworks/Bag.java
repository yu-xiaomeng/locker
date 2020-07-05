package com.thoughtworks;

public class Bag {
    private final SizeEnum size;

    public Bag(SizeEnum size) {
        this.size = size;
    }

    public SizeEnum getSize() {
        return size;
    }
}
