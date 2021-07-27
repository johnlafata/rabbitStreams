package com.example.rabbitStreams.model;

public class ApplicationDataConfirmation {

    public static final String SUCCESS="success";

    private String status;

    public ApplicationDataConfirmation(){
    }

    public ApplicationDataConfirmation(String status){
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}