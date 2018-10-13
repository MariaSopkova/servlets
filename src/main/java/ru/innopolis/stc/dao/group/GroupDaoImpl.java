package ru.innopolis.stc.dao.group;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.GroupPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupDaoImpl implements GroupDao {
    ConnectionManager connectionManager = ConnectionManagerJDNCImpl.getInstanse();

    @Override
    public GroupPojo getGroupByID(int id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from \"group\" where id = ?"
            )
        ) {
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                return createGroup(resultSet);
            }
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }

    private GroupPojo createGroup(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return new GroupPojo(
                        resultSet.getInt("id"),
                        resultSet.getInt("course"),
                        resultSet.getInt("house")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }
}
