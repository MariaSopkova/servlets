package ru.innopolis.stc.servlets.greatHall;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreatHallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HogwartsInfo hogwartsInfo = new HogwartsInfo();
        if(hogwartsInfo != null){
            req.setAttribute("HogwartsInfo", hogwartsInfo);
            req.getRequestDispatcher("greatHall.jsp").forward(req, resp);
        }
    }
}
