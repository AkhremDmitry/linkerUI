package com.asuscomm.reisin.dao;

public class Group {

    private int group_Id;
    private String group_Name;

    public int getGroupId() {
        return group_Id;
    }

    public String getGroupName() {
        return group_Name;
    }

    public void setGroupName(String groupName) {
        this.group_Name = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (group_Id != group.group_Id) return false;
        return group_Name != null ? group_Name.equals(group.group_Name) : group.group_Name == null;
    }

    @Override
    public int hashCode() {
        int result = group_Id;
        result = 31 * result + (group_Name != null ? group_Name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + group_Id +
                ", groupName='" + group_Name + '\'' +
                '}';
    }
}
