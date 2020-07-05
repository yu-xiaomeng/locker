package com.thoughtworks;

import com.thoughtworks.Exception.LockerIsFullException;

import static com.thoughtworks.SizeEnum.S;

public class SLocker {
    private int availableCapacity;

    public SLocker(int capacity) {
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (bag.getSize() == S) {
            if (this.availableCapacity > 0 ) {
                Ticket ticket = new Ticket(S);
                availableCapacity = availableCapacity - 1;
                return ticket;
            }

        }
        throw new LockerIsFullException();
    }
}
