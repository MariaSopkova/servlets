package ru.innopolis.stc.service.loginService;

import ru.innopolis.stc.dao.loginPassword.LoginPasswordDao;
import ru.innopolis.stc.dao.loginPassword.LoginPasswordImpl;
import ru.innopolis.stc.pojo.LoginPassword;
import ru.innopolis.stc.service.utils.HashUtil;

public class LoginServiceImpl implements LoginService {

    private LoginPasswordDao loginDao = new LoginPasswordImpl();

    @Override
    public LoginPassword getLoginPassword(String login, String password) {
        if( login == null || password == null )
            return null;
        LoginPassword loginPassword = loginDao.getUserByLogin(login);
        if(loginPassword != null){
            String passwordHash = HashUtil.stringToMD5(password);
            return loginPassword.getPasswordHash().equals(passwordHash) ? loginPassword : null;
        } else{
            return null;
        }
    }
}
