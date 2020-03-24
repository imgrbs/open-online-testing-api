package com.depa.demo.models;

import java.io.Serializable;

public class LeaderImpl extends Person implements Serializable {

    private String name;

    public LeaderImpl() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
