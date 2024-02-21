package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

enum MyConnector {
    ;
    private static Connection connection;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER_KEY = "user";
    private static final String USER_VALUE = "root";
    private static final String PASSWORD_KEY = "password";
    private static final String PASSWORD_VALUE = "12345";
    private static final String DATABASE_NAME = "mini-orm";
    private static final String PARAMETERS_FOR_THE_DATABASE =
            "?allowPublicKeyRetrieval=true&useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC";

    public static Connection getConnection() throws SQLException {
        createConnection();
        return connection;
    }

    private static void createConnection() throws SQLException {
        if (connection != null) return;

        Properties properties = new Properties();
        properties.setProperty(USER_KEY, USER_VALUE);
        properties.setProperty(PASSWORD_KEY, PASSWORD_VALUE);

        DriverManager.getConnection(JDBC_URL + DATABASE_NAME + PARAMETERS_FOR_THE_DATABASE, properties);
    }
}
