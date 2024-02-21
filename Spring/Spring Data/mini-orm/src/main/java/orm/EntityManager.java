package orm;

import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static entities.constants.Constants.COMMA_SEPARATOR;
import static entities.constants.Constants.ID_COLUM_MISSING_MESSAGE;
import static orm.MyConnector.getConnection;

public class EntityManager<E> implements DBContext {
    private final Connection connection;

    public EntityManager() throws SQLException {
        this.connection = getConnection();
    }

    @Override
    public boolean persist(E entity) {
        final Field idColumn = getIdColumn(entity.getClass());
        idColumn.setAccessible(true);

        final Object idValue = idColumn.get(entity);

        if (idValue == null || (long) idValue <= 0){
            return doInsert(entity);
        }
        return doUpdate(entity, idColumn);
    }

    @Override
    public Iterable find(Class table) {
        return null;
    }

    @Override
    public Iterable find(Class table, String where) {
        return null;
    }

    @Override
    public Object findFirst(Class table) {
        return null;
    }

    @Override
    public Object findFirst(Class table, String where) {
        return null;
    }
    private Field getIdColumn(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException(ID_COLUM_MISSING_MESSAGE));
    }

    private boolean doUpdate(E entity, Field idColumn) {
        return false;
    }

    private boolean doInsert(E entity) {
        final String tableName = getTableName(entity.getClass());

        final List<EntityManager.KeyValuePair> keyValuePairs = getKeyValuePairs(entity);

        final String fields = keyValuePairs.stream()
                .map(EntityManager.KeyValuePair::key)
                .collect(Collectors.joining(COMMA_SEPARATOR));

        final String values = keyValuePairs.stream()
                .map(EntityManager.KeyValuePair::value)
                .collect(Collectors.joining(COMMA_SEPARATOR));

        final String insertQuery = String.format()
        return false;
    }

    public record KeyValuePair(String key, String value){
    }
}
