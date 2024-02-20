import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    private static final String GET_MINION_BY_ID = "SELECT * FROM minions WHERE id IN ";
    private static final String GET_ALL_MINIONS = "SELECT * FROM minions";
    private static final String COLUMN_LABEL_ID = "id";
    private static final String PRINT_UPDATED_MINIONS_FORMAT = "%d %s %d%n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSqlConnection();

        final Scanner scanner = new Scanner(System.in);

        final String ids = Arrays.toString(scanner.nextLine().split(" "))
                .replaceAll("\\[", "(").replaceAll("]", ")");

        final PreparedStatement minionsStatement = connection.prepareStatement(GET_MINION_BY_ID + ids);
        final ResultSet minionsResultSet = minionsStatement.executeQuery();

        while (minionsResultSet.next()) {
            final String name = minionsResultSet.getString(Constants.COLUMN_LABEL_NAME).toLowerCase();
            final int age = minionsResultSet.getInt(Constants.COLUMN_LABEL_AGE) + 1;

            minionsResultSet.updateString(Constants.COLUMN_LABEL_NAME, name);
            minionsResultSet.updateInt(Constants.COLUMN_LABEL_AGE, age);
        }

        final PreparedStatement allMinionsStatement = connection.prepareStatement(GET_ALL_MINIONS);
        final ResultSet allMinionsResultSet = allMinionsStatement.executeQuery();

        while (allMinionsResultSet.next()) {
            final int minionId = allMinionsResultSet.getInt(COLUMN_LABEL_ID);
            final String minionName = allMinionsResultSet.getString(Constants.COLUMN_LABEL_NAME);
            final int minionAge = allMinionsResultSet.getInt(Constants.COLUMN_LABEL_AGE);

            System.out.printf(PRINT_UPDATED_MINIONS_FORMAT, minionId, minionName, minionAge);
        }
    }
}