package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.InvalidTicketException;
import com.thoughtworks.Exception.LockerIsFullException;
import com.thoughtworks.Exception.WrongTypeTicketException;

import java.util.List;

public class PrimaryLockerRobot {
    private final List<AbstractLocker> lockers;

    public PrimaryLockerRobot(List<AbstractLocker> lockers) {
        checkLockersConfig(lockers);
        this.lockers = lockers;
    }

    private void checkLockersConfig(List<AbstractLocker> lockers) {
        if (lockers.isEmpty()) {
            throw new ConfigErrorException();
        }
        for(AbstractLocker locker: lockers) {
            if(locker instanceof MLocker == false) {
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

    private AbstractLocker selectValidLocker() {
        for (AbstractLocker locker : lockers) {
            if (locker.getAvailableCapacity() > 0) {
                return locker;
            }
        }
        return null;
    }

    public Bag pickUp(Ticket mTicket) {
        if (mTicket.getSize() != SizeEnum.M) {
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
