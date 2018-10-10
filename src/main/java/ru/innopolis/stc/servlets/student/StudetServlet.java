package ru.innopolis.stc.servlets.student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getSession().getAttribute("login");
        if (login != null){
            StudentInformation studentInformation = new StudentInformation(login);
            if(studentInformation.isFullObject()){
                req.setAttribute("studentInfo", studentInformation);
                req.getRequestDispatcher("/student").forward(req,resp);
            }

        }
    }
}
