package ru.innopolis.stc.servlets;

import ru.innopolis.stc.pojo.LoginPassword;
import ru.innopolis.stc.service.loginService.LoginService;
import ru.innopolis.stc.service.loginService.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WelcomeServlet extends HttpServlet {
    public String test = "Test";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("Test", test);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        LoginPassword loginPassword = loginService.getLoginPassword(login, password);
        if( loginPassword != null ) {
            resp.sendRedirect("/test");
        } else {
            //TODO логирование
            resp.sendRedirect("/index");
        }
    }
}
