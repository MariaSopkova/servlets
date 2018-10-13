package ru.innopolis.stc.dao.student;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.LoginPassword;
import ru.innopolis.stc.pojo.StudentPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    ConnectionManager connectionManager = ConnectionManagerJDNCImpl.getInstanse();

    @Override
    public StudentPojo getStudentByLogin(String login) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM students WHERE login = ?"
             )){
            preparedStatement.setString(1,login);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return createStudent(resultSet);
            } catch (Exception ex){
                //TODO залогировать
                return null;
            }
        }  catch (Exception ex){
            //TODO залогировать
            return null;
        }
    }

    private StudentPojo createStudent(ResultSet resultSet){
        try {
            if (resultSet.next()){
                return new StudentPojo(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("group"),
                        resultSet.getString("login")
                );
            } else{
                return null;
            }
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }
}
