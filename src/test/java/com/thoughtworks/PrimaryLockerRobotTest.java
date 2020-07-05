package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.robot.PrimaryLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

public class PrimaryLockerRobotTest {
    @Test(expected = ConfigErrorException.class)
    public void should_throw_ConfigErrorException_when_config_primary_locker_robot_given_configuration_list_not_only_has_a_m_locker_but_also_a_invalid_s_and_l_locker() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(5);
        LLocker lLocker = new LLocker(5);

        new PrimaryLockerRobot(asList(sLocker, mLocker, lLocker));
    }

    @Test(expected = ConfigErrorException.class)
    public void should_throw_ConfigErrorException_when_config_primary_locker_robot_given_configuration_list_is_not_contain_any_locker() {
        new PrimaryLockerRobot(asList());
    }

    @Test
    public void should_store_in_1st_m_locker_and_get_m_ticket_when_primary_locker_robot_store_a_m_bag_given_robot_manage_2_m_lockers_both_have_available_capacity() {
        MLocker mLocker1 = new MLocker(5);
        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(asList(mLocker1, new MLocker(4)));
        Bag mBag = new Bag(SizeEnum.M);

        Ticket mTicket = primaryLockerRobot.store(mBag);

        Assert.assertNotNull(mTicket);
        Bag myBag = mLocker1.pickUp(mTicket);
        Assert.assertEquals(myBag, mBag);
    }
}
