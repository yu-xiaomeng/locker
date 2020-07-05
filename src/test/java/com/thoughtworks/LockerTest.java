package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

import static com.thoughtworks.SizeEnum.S;

public class LockerTest {
    @Test
    public void should_return_s_ticket_when_s_locker_save_small_bag_given_s_locker_has_available_capacity() {
        SLocker sLocker = new SLocker(5);

        Ticket ticket = sLocker.store(new Bag(S));

        Assert.assertNotNull(ticket);
        Assert.assertEquals(ticket.getSize(), S);
    }
}
