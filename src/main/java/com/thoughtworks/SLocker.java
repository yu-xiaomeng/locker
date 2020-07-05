package com.thoughtworks;

public class SLocker extends AbstractLocker{

    public SLocker(int capacity) {
        super(capacity, SizeEnum.S);
    }
}
