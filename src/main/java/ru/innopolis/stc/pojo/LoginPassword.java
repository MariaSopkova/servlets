package ru.innopolis.stc.pojo;

public class LoginPassword {
    private String login;
    private String passwordHash;
    private Roles role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public LoginPassword(String login, String passwordHash, int role) {
        this.login = login;
        this.passwordHash = passwordHash;
        this.role = getRoleByInt(role);
    }

    public static Roles getRoleByInt(int roleInt){
        switch (roleInt){
            default: return Roles.none;
            case 1: return Roles.student;
            case 2: return Roles.teacher;
            case 3: return Roles.headmaster;
        }
    }
}
