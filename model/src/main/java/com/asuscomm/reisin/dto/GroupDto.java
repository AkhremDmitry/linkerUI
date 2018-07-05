package com.asuscomm.reisin.dto;

import com.asuscomm.reisin.dao.AbstractGroup;
import com.asuscomm.reisin.dao.Link;

import java.util.ArrayList;

public class GroupDto extends AbstractGroup {

    private ArrayList<Link> links = new ArrayList<>();

    public GroupDto (){
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void setLinks(ArrayList<Link> links) {
        this.links = links;
    }
}
