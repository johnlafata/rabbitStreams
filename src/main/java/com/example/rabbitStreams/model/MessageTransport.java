package com.example.rabbitStreams.model;

public class MessageTransport {
    String message;

    public MessageTransport(){ }

    public MessageTransport(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageTransport{" +
                "message='" + message + '\'' +
                '}';
    }
}
