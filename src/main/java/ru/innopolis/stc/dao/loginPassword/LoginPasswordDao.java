package ru.innopolis.stc.dao.loginPassword;

import ru.innopolis.stc.pojo.LoginPassword;

public interface LoginPasswordDao {
    public LoginPassword getUserByLogin(String login);
}
