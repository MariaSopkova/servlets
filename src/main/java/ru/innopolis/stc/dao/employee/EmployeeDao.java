package ru.innopolis.stc.dao.employee;

import ru.innopolis.stc.pojo.EmployeePojo;

public interface EmployeeDao {
    public EmployeePojo getEmployeeByLogin(String login);
}
