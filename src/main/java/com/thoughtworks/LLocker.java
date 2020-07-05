package com.thoughtworks;

public class LLocker extends AbstractLocker{

    public LLocker(int capacity) {
        super(capacity, SizeEnum.L);
    }
}
