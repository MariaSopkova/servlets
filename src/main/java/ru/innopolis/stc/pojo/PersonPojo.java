package ru.innopolis.stc.pojo;

public class PersonPojo {
    private String name;
    private String surname;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public PersonPojo(int id, String name, String surname, String login) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.id = id;
    }
}
