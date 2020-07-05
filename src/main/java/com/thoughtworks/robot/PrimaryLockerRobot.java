package com.thoughtworks.robot;

import com.thoughtworks.AbstractLocker;
import com.thoughtworks.Bag;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.MLocker;
import com.thoughtworks.Ticket;

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
        for(AbstractLocker locker: lockers) {
            return locker.store(mBag);
        }
        return null;
    }
}
