package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.InvalidTicketException;
import com.thoughtworks.Exception.LockerIsFullException;
import com.thoughtworks.Exception.WrongTypeTicketException;

import java.util.List;

public abstract class AbstractLockerRobot {
    private final List<AbstractLocker> lockers;
    private final SizeEnum manageSize;

    public AbstractLockerRobot(List<AbstractLocker> lockers, SizeEnum size) {
        this.manageSize = size;
        checkLockersConfig(lockers);
        this.lockers = lockers;
    }

    public List<AbstractLocker> getLockers() {
        return lockers;
    }

    private void checkLockersConfig(List<AbstractLocker> lockers) {
        if (lockers.isEmpty()) {
            throw new ConfigErrorException();
        }
        for(AbstractLocker locker: lockers) {
            if(locker.getSize() != manageSize) {
                throw new ConfigErrorException();
            }
        }
    }

    public Ticket store(Bag mBag) {
        AbstractLocker selectedLocker = this.selectValidLocker();
        if (selectedLocker == null) {
            throw new LockerIsFullException();
        }
        return selectedLocker.store(mBag);
    }

    protected abstract AbstractLocker selectValidLocker();

    public Bag pickUp(Ticket mTicket) {
        if (mTicket.getSize() != manageSize) {
            throw new WrongTypeTicketException();
        }
        for (AbstractLocker locker : lockers) {
            Bag bag = locker.pickUp(mTicket);
            if (bag != null) {
                return bag;
            }
        }
        throw new InvalidTicketException();
    }
}
