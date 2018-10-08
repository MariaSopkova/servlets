package ru.innopolis.stc.dao.loginPassword;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.LoginPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPasswordImpl implements LoginPasswordDao {
    ConnectionManager connectionManager = ConnectionManagerJDNCImpl.getInstanse();

    @Override
    public LoginPassword getUserByLogin(String login){
        try (Connection connection = connectionManager.getConnection() ;
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM login WHERE login.login = ?"
        )){
            preparedStatement.setString(1,login);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if (resultSet.next()){
                    return new LoginPassword(
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getInt("role")
                    );
                }
            } catch (Exception ex){
                //TODO залогировать
                return null;
            }
        }  catch (Exception ex){
            //TODO залогировать
            return null;
        }
        return null;
    }
}
