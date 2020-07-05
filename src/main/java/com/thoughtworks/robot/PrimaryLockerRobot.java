package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.InvalidTicketException;
import com.thoughtworks.Exception.LockerIsFullException;
import com.thoughtworks.Exception.WrongTypeTicketException;

import java.util.List;

public class PrimaryLockerRobot extends AbstractLockerRobot{

    public PrimaryLockerRobot(List<AbstractLocker> lockers) {
        super(lockers, SizeEnum.M);
    }

    @Override
    protected AbstractLocker selectValidLocker() {
        for (AbstractLocker locker : getLockers()) {
            if (locker.getAvailableCapacity() > 0) {
                return locker;
            }
        }
        return null;
    }

}
