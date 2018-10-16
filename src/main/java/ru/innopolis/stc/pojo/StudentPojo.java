package ru.innopolis.stc.pojo;

public class StudentPojo extends PersonPojo {
    private int groupID;

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public StudentPojo(int id, String name, String surname, int groupID, String login) {
        super(id, name, surname, login);
        this.groupID = groupID;
    }
}
