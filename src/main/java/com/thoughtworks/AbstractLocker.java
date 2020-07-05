package com.thoughtworks;

import com.thoughtworks.Exception.InvalidTicketException;
import com.thoughtworks.Exception.LockerIsFullException;
import com.thoughtworks.Exception.WrongTypeTicketException;

import java.util.HashMap;

public abstract class AbstractLocker {
    private final int capacity;
    private int availableCapacity;
    private HashMap<Ticket, Bag> savedBags = new HashMap<>();
    private final SizeEnum size;

    public AbstractLocker(int capacity, SizeEnum size) {
        this.capacity = capacity;
        this.availableCapacity = capacity;
        this.size = size;
    }

    public Ticket store(Bag bag) {
        if (bag.getSize() == size) {
            if (this.availableCapacity > 0 ) {
                Ticket ticket = new Ticket(size);
                availableCapacity --;
                savedBags.put(ticket, bag);
                return ticket;
            }

        }
        throw new LockerIsFullException();
    }

    public SizeEnum getSize() {
        return size;
    }

    public Bag pickUp(Ticket ticket) {
        if (ticket.getSize() != size) {
            throw new WrongTypeTicketException();
        }
        Bag bag = savedBags.remove(ticket);
        if (bag != null) {
            availableCapacity ++;
            return bag;
        }

        throw new InvalidTicketException();
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public double getVacancyRate() {
        return this.getAvailableCapacity() / this.capacity;
    }
}
