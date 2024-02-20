import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {
    private static final String GET_VILLAIN_NAME_BY_ID =
            "select name from villains where id = ?";
    private static final String GET_COUNT_OF_MINIONS_BY_VILLAIN =
            "select count(*) as m_count from minions_villains where villain_id = ?";
    private static final String DELETE_MINIONS_VILLAINS_BY_ID =
            "delete from minions_villains where villain_id = ?";
    private static final String DELETE_VILLAIN_BY_ID =
            "delete from villains where id = ?";

    private static final String PRINT_RELEASED_MINIONS_FORMAT = "%d minions released";
    private static final String PRINT_DELETED_VILLAIN_FORMAT = "%s was deleted";
    private static final String PRINT_NO_VILLAIN_FOUND_FORMAT = "No such villain were found";

    public static void main(String[] args) throws SQLException {
        final Connection connection = Utils.getSqlConnection();

        final int villainId = new Scanner(System.in).nextInt();

        final PreparedStatement getVillainStatement = connection.prepareStatement(GET_VILLAIN_NAME_BY_ID);
        getVillainStatement.setInt(1, villainId);

        final ResultSet villainResultSet = getVillainStatement.executeQuery();

        if (!villainResultSet.next()) {
            System.out.println(PRINT_NO_VILLAIN_FOUND_FORMAT);
            connection.close();
            return;
        }

        final String villainName = villainResultSet.getString(1);

        final PreparedStatement getCountMinionsStatement = connection.prepareStatement(GET_COUNT_OF_MINIONS_BY_VILLAIN);
        getCountMinionsStatement.setInt(1, villainId);

        final ResultSet minionsCountResultSet = getCountMinionsStatement.executeQuery();
        minionsCountResultSet.next();

        int countOfMinionsReleased = minionsCountResultSet.getInt(1);

        connection.setAutoCommit(false);

        try(PreparedStatement deleteMinionsStatement = connection.prepareStatement(DELETE_MINIONS_VILLAINS_BY_ID);
            PreparedStatement deleteVillainStatement = connection.prepareStatement(DELETE_VILLAIN_BY_ID))
        {
            deleteMinionsStatement.setInt(1, villainId);
            deleteMinionsStatement.executeUpdate();

            deleteVillainStatement.setInt(1, villainId);
            deleteVillainStatement.executeUpdate();

            connection.commit();

            System.out.printf(PRINT_DELETED_VILLAIN_FORMAT, villainName);
            System.out.println();
            System.out.printf(PRINT_RELEASED_MINIONS_FORMAT, countOfMinionsReleased);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();

            connection.rollback();
        }
    }
}