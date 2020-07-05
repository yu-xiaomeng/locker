package com.thoughtworks;

import com.thoughtworks.Exception.LockerIsFullException;
import org.junit.Assert;
import org.junit.Test;

import static com.thoughtworks.SizeEnum.S;

public class LockerTest {
    @Test
    public void should_return_s_ticket_when_s_locker_store_small_bag_given_s_locker_has_available_capacity() {
        SLocker sLocker = new SLocker(5);

        Ticket ticket = sLocker.store(new Bag(S));

        Assert.assertNotNull(ticket);
        Assert.assertEquals(ticket.getSize(), S);
    }

    @Test(expected = LockerIsFullException.class)
    public void should_throw_LockerIsFullException__when_s_locker_store_small_bag_given_s_locker_is_full() {
        SLocker sLocker = new SLocker(1);
        sLocker.store(new Bag(S));

        sLocker.store(new Bag(S));
    }
}
