package org.ubt.chat.model;


public class Message {

    private String message;

    public Message() {

    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("Model [message=%s]", message);
    }

}