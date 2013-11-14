package ru.tver.hackaton.beans;

import java.io.Serializable;

public class TestBean implements Serializable{

    int id;
    String message;

    public TestBean() {
    }

    public TestBean(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
