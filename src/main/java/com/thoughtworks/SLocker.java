package com.thoughtworks;

import static com.thoughtworks.SizeEnum.S;

public class SLocker {
    private final int availableCapacity;

    public SLocker(int capacity) {
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (bag.getSize() == S) {
            return new Ticket(S);
        }
        return null;
    }
}
