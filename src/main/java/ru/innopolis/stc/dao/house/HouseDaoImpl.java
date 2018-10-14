package ru.innopolis.stc.dao.house;

import ru.innopolis.stc.connection.ConnectionManager;
import ru.innopolis.stc.connection.ConnectionManagerJDNCImpl;
import ru.innopolis.stc.pojo.HousePojo;
import ru.innopolis.stc.pojo.StudentPojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            return null;
        }
    }

    private HousePojo createHouse(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return createHousePojo(resultSet);
            } else{
                return null;
            }
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }

    private HousePojo createHousePojo(ResultSet resultSet) throws SQLException {
        return new HousePojo(
                resultSet.getString("name"),
                resultSet.getInt("head"),
                resultSet.getInt("id"),
                resultSet.getInt("score")
        );
    }

    @Override
    public List<StudentPojo> getStudentsByHouse(int id) {
       try(Connection connection = connectionManager.getConnection();
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "select *, students.id as stud_id, students.\"group\" as stud_group from \"group\" right join students on \"group\".id=students.\"group\" where \"group\".house=?"
           )
       ) {
           preparedStatement.setInt(1, id);
           try(ResultSet resultSet = preparedStatement.executeQuery()){
                return getStudentList(resultSet);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return null;
    }

    private List<StudentPojo> getStudentList(ResultSet resultSet){
        List<StudentPojo> students = new ArrayList<>();
        try{
            while (resultSet.next()){
                StudentPojo studentPojo = new StudentPojo(
                        resultSet.getInt("stud_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getInt("stud_group"),
                        resultSet.getString("login")
                );
                students.add(studentPojo);
            }
            return students;
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<HousePojo> getHouses() {
        List<HousePojo> houses = new ArrayList<>();
        try(Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM house"
        )){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                houses.add(createHousePojo(resultSet));
            }
            return houses;
        } catch (SQLException e) {
            //TODO залогировать
            e.printStackTrace();
            return null;
        }
    }
}
