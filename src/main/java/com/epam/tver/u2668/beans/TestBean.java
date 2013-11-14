package com.epam.tver.u2668.beans;

import java.io.Serializable;

public class TestBean implements Serializable{

    private int id;
    private String message;

    public TestBean() {}

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
