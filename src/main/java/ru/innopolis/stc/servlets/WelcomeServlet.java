package ru.innopolis.stc.servlets;

import ru.innopolis.stc.pojo.LoginPassword;
import ru.innopolis.stc.pojo.Roles;
import ru.innopolis.stc.service.Logger;
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
        if(req.getSession().getAttribute("role") != null ) {
            redirectByRole(resp, (Roles) req.getSession().getAttribute("role"));
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginService loginService = new LoginServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginPassword loginPassword = loginService.getLoginPassword(login, password);
        if( loginPassword != null ) {
            Logger.AddSuccessfulLoginInfo(login);
            setSessionData(req, loginPassword);
            redirectByRole(resp, loginPassword.getRole());
        } else {
            Logger.AddNotSuccessfulLoginInfo(login);
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
            case headmaster:{
                resp.sendRedirect("/headmaster");
                break;
            }
            default:{
                resp.sendRedirect("/index?action=noAuth");
                break;
            }
        }

    }
}
