package com.thoughtworks.Exception;

public class WrongTypeTicketException extends RuntimeException {
    public WrongTypeTicketException() {
        super("票据类型错误");
    }
}
