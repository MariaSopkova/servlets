package ru.innopolis.stc.service.loginService;

import ru.innopolis.stc.pojo.LoginPassword;

public interface LoginService {
    public LoginPassword getLoginPassword(String login, String password);
}
