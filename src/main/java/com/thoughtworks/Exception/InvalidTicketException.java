package com.thoughtworks.Exception;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException() {
        super("非法票据");
    }
}
