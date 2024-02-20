package org.example.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    public static final  String URL_KEY = "postgres.url";
    public static final String USER_KEY = "postgres.username";
    public static final  String PASSWORD_KEY = "postgres.password";
    private ConnectionManager(){}

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection open(){
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                        PropertiesUtil.get(USER_KEY),
                            PropertiesUtil.get(PASSWORD_KEY));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
