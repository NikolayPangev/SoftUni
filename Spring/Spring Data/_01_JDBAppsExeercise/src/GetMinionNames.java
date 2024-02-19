import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
    private static final String GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID =
            " select m.name, m.age " +
                    " from minions m " +
                    " join minions_db.minions_villains mv on m.id = mv.minion_id " +
                    " where mv.villain_id = ?;";

    private static final String GET_VILLAINS_NAME_BY_ID = "select name from villains where id = ?;";

    private static final String PRINT_VILLAIN_FORMAT = "Villain: %s\n";
    private static final String PRINT_MINION_FORMAT = "%d. %s %d\n";
    private static final String PRINT_NO_VILLAIN_FOUND_FORMAT = "No villain with ID %d exists in the database.\n";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSqlConnection();

        final int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement statementForVillains = connection.prepareStatement(GET_VILLAINS_NAME_BY_ID);
        statementForVillains.setInt(1, villainId);

        ResultSet villainResultSet = statementForVillains.executeQuery();

        if (!villainResultSet.next()) {
            System.out.printf(PRINT_NO_VILLAIN_FOUND_FORMAT, villainId);
            connection.close();
            return;
        }

        final PreparedStatement statementForMinions = connection.prepareStatement(GET_MINIONS_NAME_AND_AGE_BY_VILLAIN_ID);
        statementForMinions.setInt(1, villainId);

        ResultSet minionsResultSet = statementForMinions.executeQuery();

        print(villainResultSet, minionsResultSet);

        connection.close();
    }

    private static void print(ResultSet villains, ResultSet minions) throws SQLException {
        final String villainName = villains.getString(Constants.COLUMN_LABEL_NAME);

        System.out.printf(PRINT_VILLAIN_FORMAT, villainName);

        for (int index = 1; minions.next(); index++) {
            final String minionName = minions.getString(Constants.COLUMN_LABEL_NAME);
            final int minionAge = minions.getInt(Constants.COLUMN_LABEL_AGE);

            System.out.printf(PRINT_MINION_FORMAT, index, minionName, minionAge);
        }
    }
}