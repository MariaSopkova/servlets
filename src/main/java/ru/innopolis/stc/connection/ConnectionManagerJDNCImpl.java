package ru.innopolis.stc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJDNCImpl implements ConnectionManager{

    private static ConnectionManager connectionManager;
    private Connection connection;

    private ConnectionManagerJDNCImpl()
    {

    }
    public static ConnectionManager getInstanse(){
        if(connectionManager == null){
            connectionManager = new ConnectionManagerJDNCImpl();
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() throws SQLException {
        //if( connection != null ){
        //    return connection;
        //}
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hogwarts",
                    "postgres", "postgres123");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
