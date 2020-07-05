package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.robot.LockerRobotManager;
import com.thoughtworks.robot.PrimaryLockerRobot;
import com.thoughtworks.robot.SuperLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

public class LockerRobotManagerTest {

    @Test
    public void should_store_in_s_locker_and_get_a_s_ticket_when_locker_robot_manager_store_s_bag_given_the_s_locker_has_available_capacity() {
        SLocker sLocker = new SLocker(5);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new MLocker(6)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(new LLocker(3)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag sBag = new Bag(SizeEnum.S);

        Ticket sTicket = lockerRobotManager.store(sBag);

        Assert.assertNotNull(sTicket);
        Assert.assertEquals(SizeEnum.S, sTicket.getSize());
        Bag myBag = sLocker.pickUp(sTicket);
        Assert.assertEquals(myBag, sBag);
    }
}
