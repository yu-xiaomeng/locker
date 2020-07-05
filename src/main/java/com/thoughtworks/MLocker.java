package com.thoughtworks;

public class MLocker extends AbstractLocker{
    public MLocker(int capacity) {
        super(capacity, SizeEnum.M);
    }
}
