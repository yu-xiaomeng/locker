package com.thoughtworks.robot;

import com.thoughtworks.AbstractLocker;
import com.thoughtworks.Bag;
import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.SLocker;
import com.thoughtworks.Ticket;

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
        return sLocker.store(bag);
    }
}
