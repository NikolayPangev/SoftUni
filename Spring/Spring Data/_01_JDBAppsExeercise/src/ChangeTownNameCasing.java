import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeTownNameCasing {
    private static final String UPDATE_TOWN_NAME = "update towns t set name = upper(name) where t.country = ?";
    private static final String GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME =
            "select t.name from towns t where t.country = ?";
    private static final String NO_TOWNS_AFFECTED_MESSAGE = "No town names were affected";
    private static final String COUNT_OF_AFFECTED_TOWNS_FORMAT = "%d town names were affected.%n";

    public static void main(String[] args) throws SQLException {
        final Connection sqlConnection = Utils.getSqlConnection();

        final String countryName = new Scanner(System.in).nextLine();

        final PreparedStatement statement = sqlConnection.prepareStatement(UPDATE_TOWN_NAME);
        statement.setString(1, countryName);

        final int updatedCount = statement.executeUpdate();

        if (updatedCount == 0) {
            System.out.println(NO_TOWNS_AFFECTED_MESSAGE);
            sqlConnection.close();
            return;
        }

        System.out.printf(COUNT_OF_AFFECTED_TOWNS_FORMAT, updatedCount);

        final PreparedStatement selectAllTowns = sqlConnection.prepareStatement(GET_ALL_TOWN_NAMES_BY_COUNTRY_NAME);
        selectAllTowns.setString(1, countryName);

        final ResultSet allTownsResultSet = selectAllTowns.executeQuery();

        ArrayList<String> towns = new ArrayList<>();

        while (allTownsResultSet.next()) {
            towns.add(allTownsResultSet.getString(Constants.COLUMN_LABEL_NAME));
        }

        System.out.println(towns);
    }
}