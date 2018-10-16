package ru.innopolis.stc.dao.employee;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.EmployeePojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    private ConnectionManager connectionManager = ConnectionManagerJDNCImpl.getInstanse();

    @Override
    public EmployeePojo getEmployeeByLogin(String login) {
        if(login == null || login.isEmpty())
            return null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from employee where login=?"
             )) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                return createEmployee(resultSet);
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private EmployeePojo createEmployee(ResultSet resultSet) throws SQLException {
        if(resultSet.next()){
            return new EmployeePojo(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("login"),
                    resultSet.getInt("position")
            );
        } else{
            return null;
        }
    }
}
