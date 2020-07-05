package com.thoughtworks.robot;

import com.thoughtworks.AbstractLocker;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.LLocker;
import com.thoughtworks.MLocker;

import java.util.List;

public class SuperLockerRobot {

    public SuperLockerRobot(List<AbstractLocker> lockers) {
        checkLockersConfig(lockers);
    }

    private void checkLockersConfig(List<AbstractLocker> lockers) {
        for(AbstractLocker locker: lockers) {
            if(locker instanceof LLocker == false) {
                throw new ConfigErrorException();
            }
        }
    }
}
