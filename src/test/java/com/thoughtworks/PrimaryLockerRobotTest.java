package com.thoughtworks;

import com.thoughtworks.Exception.ConfigErrorException;
import com.thoughtworks.robot.PrimaryLockerRobot;
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
}
