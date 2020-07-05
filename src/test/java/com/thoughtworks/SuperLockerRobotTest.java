package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.robot.PrimaryLockerRobot;
import com.thoughtworks.robot.SuperLockerRobot;
import org.junit.Assert;
import org.junit.Test;

import static java.util.Arrays.asList;

public class SuperLockerRobotTest {
    @Test(expected = ConfigErrorException.class)
    public void should_throw_ConfigErrorException_when_config_super_locker_robot_given_configuration_list_not_only_has_a_l_locker_but_also_a_invalid_s_and_m_locker() {
        SLocker sLocker = new SLocker(5);
        MLocker mLocker = new MLocker(5);
        LLocker lLocker = new LLocker(5);

        new SuperLockerRobot(asList(sLocker, mLocker, lLocker));
    }

    @Test(expected = ConfigErrorException.class)
    public void should_throw_ConfigErrorException_when_config_super_locker_robot_given_configuration_list_is_not_contain_any_locker() {
        new SuperLockerRobot(asList());
    }

    @Test
    public void should_store_in_1st_l_locker_and_get_a_l_ticket_when_super_locker_robot_store_a_l_bag_given_robot_manage_2_locker_and_1st_locker_vacancy_rate_is_larger_than_2nd_locker() {
        LLocker lLocker1 = new LLocker(5);
        LLocker lLocker2 = new LLocker(2);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(asList(lLocker1, lLocker2));
        Bag lBag = new Bag(SizeEnum.L);

        Ticket lTicket = superLockerRobot.store(lBag);

        Assert.assertNotNull(lTicket);
        Assert.assertEquals(SizeEnum.L, lTicket.getSize());
        Bag myBag = lLocker1.pickUp(lTicket);
        Assert.assertEquals(myBag, lBag);
    }
}
