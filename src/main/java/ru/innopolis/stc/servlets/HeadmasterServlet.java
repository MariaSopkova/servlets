package ru.innopolis.stc.servlets;

import ru.innopolis.stc.dao.employee.EmployeeDao;
import ru.innopolis.stc.dao.employee.EmployeeDaoImpl;
import ru.innopolis.stc.pojo.EmployeePojo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeadmasterServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = (String)req.getAttribute("login");
        EmployeePojo employeePojo = employeeDao.getEmployeeByLogin(login);
        if(employeePojo != null){
            req.setAttribute("EmployeeInfo", employeePojo);
        }
        req.getRequestDispatcher("/headmaster.jsp").forward(req, resp);
    }
}
