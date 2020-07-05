package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.robot.PrimaryLockerRobot;
import com.thoughtworks.robot.SuperLockerRobot;
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
}
