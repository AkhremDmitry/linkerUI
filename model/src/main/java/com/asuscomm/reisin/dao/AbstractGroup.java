package com.asuscomm.reisin.dao;

public abstract class AbstractGroup {

    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
