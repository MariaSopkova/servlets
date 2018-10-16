package ru.innopolis.stc.pojo;

import static ru.innopolis.stc.pojo.LoginPassword.getRoleByInt;

public class EmployeePojo extends PersonPojo {
    private Roles position;

    public EmployeePojo(int id, String name, String surname, String login, int position) {
        super(id, name, surname, login);
        this.position = getRoleByInt(position);
    }

    public Roles getPosition() {
        return position;
    }

    public void setPosition(Roles position) {
        this.position = position;
    }
}
