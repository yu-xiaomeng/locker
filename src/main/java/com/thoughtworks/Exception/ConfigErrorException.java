package com.thoughtworks.Exception;

public class ConfigErrorException extends RuntimeException {
    public ConfigErrorException() {
        super("配置错误");
    }
}
