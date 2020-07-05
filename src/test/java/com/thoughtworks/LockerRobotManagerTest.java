package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.Exception.LockerIsFullException;
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

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_robot_manager_store_s_bag_given_the_s_locker_is_full() {
        SLocker sLocker = new SLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(new MLocker(6)));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(new LLocker(3)));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        lockerRobotManager.store(new Bag(SizeEnum.S));
        Bag sBag = new Bag(SizeEnum.S);

        lockerRobotManager.store(sBag);
    }

    @Test
    public void should_store_in_m_locker_and_get_a_m_ticket_when_locker_robot_manager_store_m_bag_given_the_m_locker_has_available_capacity() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(4);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.M);

        Ticket ticket = lockerRobotManager.store(bag);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(SizeEnum.M, ticket.getSize());
        Bag myBag = mLocker.pickUp(ticket);
        Assert.assertEquals(myBag, bag);
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_robot_manager_store_m_bag_given_the_m_locker_is_full() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(1);
        LLocker lLocker = new LLocker(4);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        lockerRobotManager.store(new Bag(SizeEnum.M));
        Bag bag = new Bag(SizeEnum.M);

        lockerRobotManager.store(bag);
    }

    @Test
    public void should_store_in_l_locker_and_get_a_l_ticket_when_locker_robot_manager_store_l_bag_given_the_l_locker_has_available_capacity() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(4);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.L);

        Ticket ticket = lockerRobotManager.store(bag);

        Assert.assertNotNull(ticket);
        Assert.assertEquals(SizeEnum.L, ticket.getSize());
        Bag myBag = lLocker.pickUp(ticket);
        Assert.assertEquals(myBag, bag);
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException_when_locker_robot_manager_store_l_bag_given_the_l_locker_is_full() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        lockerRobotManager.store(new Bag(SizeEnum.L));
        Bag bag = new Bag(SizeEnum.L);

        lockerRobotManager.store(bag);
    }

    @Test
    public void should_get_bag_when_locker_robot_manager_pick_up_bag_given_a_valid_s_ticket() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.S);
        Ticket ticket = lockerRobotManager.store(bag);

        Bag myBag = lockerRobotManager.pickUp(ticket);

        Assert.assertEquals(bag, myBag);
    }

    @Test
    public void should_get_bag_when_locker_robot_manager_pick_up_bag_given_a_valid_m_ticket() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.M);
        Ticket ticket = lockerRobotManager.store(bag);

        Bag myBag = lockerRobotManager.pickUp(ticket);

        Assert.assertEquals(bag, myBag);
    }

    @Test
    public void should_get_bag_when_locker_robot_manager_pick_up_bag_given_a_valid_l_ticket() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.L);
        Ticket ticket = lockerRobotManager.store(bag);

        Bag myBag = lockerRobotManager.pickUp(ticket);

        Assert.assertEquals(bag, myBag);
    }

    @Test
    public void should_throw_InvalidTicketException_when_locker_robot_manager_pick_up_bag_given_an_invalid_ticket() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(6);
        LLocker lLocker = new LLocker(1);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker));
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker));
        LockerRobotManager lockerRobotManager = new LockerRobotManager(sLocker, primaryLockerRobot, superLockerRobot);
        Bag bag = new Bag(SizeEnum.M);

        lockerRobotManager.store(bag);


    }
}
