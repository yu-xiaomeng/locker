package com.thoughtworks;

import com.thoughtworks.Exception.LockerIsFullException;

import java.util.HashMap;

import static com.thoughtworks.SizeEnum.S;

public class SLocker {
    private int availableCapacity;
    private HashMap<Ticket, Bag> savedBags = new HashMap<>();

    public SLocker(int capacity) {
        this.availableCapacity = capacity;
    }

    public Ticket store(Bag bag) {
        if (bag.getSize() == S) {
            if (this.availableCapacity > 0 ) {
                Ticket ticket = new Ticket(S);
                availableCapacity = availableCapacity - 1;
                savedBags.put(ticket, bag);
                return ticket;
            }

        }
        throw new LockerIsFullException();
    }

    public Bag pickUp(Ticket ticket) {
        Bag bag = savedBags.remove(ticket);
        return bag;
    }
}
