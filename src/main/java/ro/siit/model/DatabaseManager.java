package ro.siit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    private Connection connection;

    private static DatabaseManager instance;

    private DatabaseManager(String type, String host, String port, String dbName, String user, String pw) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

        this.connection = buildConnection(type, host, port, dbName, user, pw);
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager("postgresql", "localhost", "5432", "scoreXO", "marianad", "1234");
        }
        return instance;
    }

    private Connection buildConnection(String type, String host, String port, String dbName, String user, String pw) {
        DriverManager.setLoginTimeout(60);
        try {
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append(type)
                    .append("://")
                    .append(host)
                    .append(":")
                    .append(port)
                    .append("/")
                    .append(dbName)
                    .append("?user=")
                    .append(user)
                    .append("&password=")
                    .append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }
        return null;
    }
}