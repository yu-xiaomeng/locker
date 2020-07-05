package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.LockerIsFullException;

import java.util.List;

public class SuperLockerRobot extends AbstractLockerRobot{

    public SuperLockerRobot(List<AbstractLocker> lockers) {
        super(lockers, SizeEnum.L);
    }

    @Override
    protected AbstractLocker selectValidLocker() {
        List<AbstractLocker> lockers = getLockers();
        AbstractLocker selectedLocker = lockers.get(0);
        for (AbstractLocker locker : lockers) {
            if (locker.getVacancyRate() > selectedLocker.getVacancyRate()) {
                selectedLocker = locker;
            }
        }
        if (selectedLocker.getVacancyRate() > 0) {
            return selectedLocker;
        }
        return null;
    }
}
