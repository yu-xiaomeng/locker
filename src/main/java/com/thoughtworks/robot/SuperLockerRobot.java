package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;

import java.util.List;

public class SuperLockerRobot {
    private final List<AbstractLocker> lockers;

    public SuperLockerRobot(List<AbstractLocker> lockers) {
        checkLockersConfig(lockers);
        this.lockers = lockers;
    }

    private void checkLockersConfig(List<AbstractLocker> lockers) {
        if (lockers.isEmpty()) {
            throw new ConfigErrorException();
        }
        for(AbstractLocker locker: lockers) {
            if(locker instanceof LLocker == false) {
                throw new ConfigErrorException();
            }
        }
    }

    public Ticket store(Bag lBag) {
        return lockers.get(0).store(lBag);
    }
}
