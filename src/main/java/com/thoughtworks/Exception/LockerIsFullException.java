package com.thoughtworks.Exception;

public class LockerIsFullException extends RuntimeException {
    public LockerIsFullException() {
        super("储物柜已满");
    }
}
