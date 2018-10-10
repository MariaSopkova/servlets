package ru.innopolis.stc.pojo;

public class StudentPojo {
    private String name;
    private String surname;
    private int groupID;
    private String login;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public StudentPojo(int id, String name, String surname, int groupID, String login) {
        this.name = name;
        this.surname = surname;
        this.groupID = groupID;
        this.login = login;
    }
}
