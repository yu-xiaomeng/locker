package com.thoughtworks;

import com.thoughtworks.Exception.InvalidTicketException;
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
    public void should_throw_LockerIsFullException_when_s_locker_store_small_bag_given_s_locker_is_full() {
        SLocker sLocker = new SLocker(1);
        sLocker.store(new Bag(S));

        sLocker.store(new Bag(S));
    }

    @Test
    public void should_get_bag_when_s_locker_pick_up_bag_given_a_valid_s_ticket() {
        SLocker sLocker = new SLocker(5);
        Bag sBag = new Bag(S);
        Ticket sTicket = sLocker.store(sBag);

        Bag myBag = sLocker.pickUp(sTicket);

        Assert.assertEquals(myBag, sBag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_InvalidTicketException_when_s_locker_pick_up_bag_given_an_invalid_s_ticket() {
        SLocker sLocker = new SLocker(5);

        sLocker.pickUp(new Ticket(S));
    }
}
