package com.thoughtworks.robot;

import com.thoughtworks.*;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.LockerIsFullException;

import java.util.List;

public class LockerRobotManager {
    private final SLocker sLocker;
    private final PrimaryLockerRobot primaryLockerRobot;
    private final SuperLockerRobot superLockerRobot;

    public LockerRobotManager(SLocker sLocker, PrimaryLockerRobot primaryLockerRobot, SuperLockerRobot superLockerRobot) {
        this.sLocker = sLocker;
        this.primaryLockerRobot = primaryLockerRobot;
        this.superLockerRobot = superLockerRobot;
    }

    public Ticket store(Bag bag) {
        if (bag.getSize() == SizeEnum.S) {
            if (sLocker.getAvailableCapacity() > 0 ) {
                return sLocker.store(bag);
            }
            throw new LockerIsFullException();
        } else if (bag.getSize() == SizeEnum.M) {
            if (primaryLockerRobot.getLockers().get(0).getAvailableCapacity() > 0 ) {
                return primaryLockerRobot.store(bag);
            }
            throw new LockerIsFullException();
        }
        return null;

    }
}
