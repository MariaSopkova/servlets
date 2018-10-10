package ru.innopolis.stc.servlets;

import ru.innopolis.stc.pojo.LoginPassword;
import ru.innopolis.stc.pojo.Roles;
import ru.innopolis.stc.service.loginService.LoginService;
import ru.innopolis.stc.service.loginService.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("role") != null )
            redirectByRole(resp,(Roles)req.getSession().getAttribute("role") );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService loginService = new LoginServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginPassword loginPassword = loginService.getLoginPassword(login, password);
        if( loginPassword != null ) {
            setSessionData(req, loginPassword);
            redirectByRole(resp, loginPassword.getRole());
        } else {
            //TODO логирование
            redirectByRole(resp, Roles.none);
        }
    }

    private void setSessionData(HttpServletRequest req, LoginPassword loginPassword){
        req.getSession().setAttribute("login", loginPassword.getLogin());
        req.getSession().setAttribute("role", loginPassword.getRole());
    }

    private void redirectByRole(HttpServletResponse resp, Roles role) throws IOException {
        switch (role){
            case student: {
                resp.sendRedirect("/student");
                break;
            }
            case teacher:{
                resp.sendRedirect("/teacher");
                break;
            }
            default:{
                resp.sendRedirect("/index?action=noAuth");
                break;
            }
        }

    }
}
