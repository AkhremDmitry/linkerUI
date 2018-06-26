package com.asuscomm.reisin.dao;

public class Link {

    private int link_Id;
    private String link_Name;
    private int group_Id;
    private String link_Url;
    private int link_Port;
    private String link_Description;

    public int getLink_Id() {
        return link_Id;
    }

    public void setLink_Id(int link_Id) {
        this.link_Id = link_Id;
    }

    public String getLink_Name() {
        return link_Name;
    }

    public void setLink_Name(String link_Name) {
        this.link_Name = link_Name;
    }

    public int getGroup_Id() {
        return group_Id;
    }

    public void setGroup_Id(int group_Id) {
        this.group_Id = group_Id;
    }

    public String getLink_Url() {
        return link_Url;
    }

    public void setLink_Url(String link_Url) {
        this.link_Url = link_Url;
    }

    public int getLink_Port() {
        return link_Port;
    }

    public void setLink_Port(int link_Port) {
        this.link_Port = link_Port;
    }

    public String getLink_Description() {
        return link_Description;
    }

    public void setLink_Description(String link_Description) {
        this.link_Description = link_Description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (link_Id != link.link_Id) return false;
        if (group_Id != link.group_Id) return false;
        if (link_Port != link.link_Port) return false;
        if (link_Name != null ? !link_Name.equals(link.link_Name) : link.link_Name != null) return false;
        if (link_Url != null ? !link_Url.equals(link.link_Url) : link.link_Url != null) return false;
        return link_Description != null ? link_Description.equals(link.link_Description) : link.link_Description == null;
    }

    @Override
    public int hashCode() {
        int result = link_Id;
        result = 31 * result + (link_Name != null ? link_Name.hashCode() : 0);
        result = 31 * result + group_Id;
        result = 31 * result + (link_Url != null ? link_Url.hashCode() : 0);
        result = 31 * result + link_Port;
        result = 31 * result + (link_Description != null ? link_Description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "link_Id=" + link_Id +
                ", link_Name='" + link_Name + '\'' +
                ", group_Id='" + group_Id + '\'' +
                ", link_Url='" + link_Url + '\'' +
                ", link_Port=" + link_Port +
                ", link_Description='" + link_Description + '\'' +
                '}';
    }
}
