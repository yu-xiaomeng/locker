package com.thoughtworks;

public class Ticket {
    private final SizeEnum size;

    public Ticket(final SizeEnum size) {
        this.size = size;
    }

    public SizeEnum getSize() {
        return size;
    }
}
