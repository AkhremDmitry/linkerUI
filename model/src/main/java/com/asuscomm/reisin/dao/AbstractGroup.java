package com.asuscomm.reisin.dao;

import javax.validation.constraints.Size;

public abstract class AbstractGroup {

    protected int id;

    @Size(min = 3, message = "Address cannot contain less "
            + "than 3 characters.")
    protected String name;

    public void setId(int id) {
        this.id = id;
    }

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
