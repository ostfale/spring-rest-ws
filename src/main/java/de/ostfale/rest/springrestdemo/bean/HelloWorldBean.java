package de.ostfale.rest.springrestdemo.bean;

/**
 * Created by Uwe Sauerbrei on 14.03.2018
 */
public class HelloWorldBean {

    private final String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return String.format("Hello world from bean with message: %s", message);
    }

    public String getMessage() {
        return message;
    }
}
