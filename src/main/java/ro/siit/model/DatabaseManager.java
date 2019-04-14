package ro.siit.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DatabaseManager {

    private Connection connection;

    public Connection getConnection(){
        return connection;
    }

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

    public List<String> getLastThreeMatches() {
        List<String> getMatches = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            ResultSet matches = statement.executeQuery("SELECT board FROM xo ORDER BY id ASC limit 3");
            while(matches.next()){
                getMatches.add(matches.getString("board"));
            }
        } catch (SQLException sqlEx){
            System.out.println(sqlEx);
        }

        return getMatches;

    }


    public void add(String matrix){
        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO xo VALUES (?, ?)");
            insertStatement.setObject(1,UUID.randomUUID());
            insertStatement.setString(2, matrix);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}