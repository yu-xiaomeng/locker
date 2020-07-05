package com.thoughtworks.robot;

import com.thoughtworks.AbstractLocker;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.MLocker;

import java.util.List;

public class PrimaryLockerRobot {
    public PrimaryLockerRobot(List<AbstractLocker> lockers) {
        for(AbstractLocker locker: lockers) {
            if(locker instanceof MLocker == false) {
                throw new ConfigErrorException();
            }

        }
    }
}
