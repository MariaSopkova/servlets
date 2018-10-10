package ru.innopolis.stc.dao.house;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.HousePojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseDaoImpl implements HouseDao{
    ConnectionManager connectionManager = ConnectionManagerJDNCImpl.getInstanse();

    @Override
    public HousePojo getHouseById(int id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM house where id = ?"
            )) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                return createHouse(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private HousePojo createHouse(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return new HousePojo(
                        resultSet.getString("name"),
                        resultSet.getInt("head"),
                        resultSet.getInt("id"),
                        resultSet.getInt("points")
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
