package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static entities.constants.Constants.*;
import static entities.constants.Constants.Queries.*;
import static orm.MyConnector.getConnection;

public class EntityManager<E> implements DBContext<E> {
    private final Connection connection;

    public EntityManager() throws SQLException {
        this.connection = getConnection();
    }

    @Override
    public boolean persist(E entity) throws SQLException, IllegalAccessException {
        final Field idColumn = getIdColumn(entity.getClass());
        idColumn.setAccessible(true);

        final Object idValue = idColumn.get(entity);

        if (idValue == null || (long) idValue <= 0) {
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


    private boolean doInsert(E entity) throws SQLException {
        final String tableName = getTableName(entity.getClass());

        final List<EntityManager.KeyValuePair> keyValuePairs = getKeyValuePairs(entity);

        final String fields = keyValuePairs.stream()
                .map(EntityManager.KeyValuePair::key)
                .collect(Collectors.joining(COMMA_SEPARATOR));

        final String values = keyValuePairs.stream()
                .map(EntityManager.KeyValuePair::value)
                .collect(Collectors.joining(COMMA_SEPARATOR));

        final String insertQuery = String.format(INSET_QUERY_FORMAT, tableName, fields, values);

        return connection.prepareStatement(insertQuery).execute();
    }

    private boolean doUpdate(E entity, Field idColumn) throws IllegalAccessException, SQLException {
        final String tableName = getTableName(entity.getClass());

        final List<EntityManager.KeyValuePair> keyValuePairs = getKeyValuePairs(entity);

        final String updateValues = keyValuePairs.stream()
                .map(keyValuePair -> String.format(UPDATE_VALUE_FORMAT, keyValuePair.key, keyValuePair.value))
                .collect(Collectors.joining(COMMA_SEPARATOR));

        final int idValue = Integer.parseInt(idColumn.get(entity).toString());

        final String insertQuery = String.format(UPDATE_QUERY_BY_ID_FORMAT, tableName, updateValues, idValue);

        return connection.prepareStatement(insertQuery).execute();
    }

    private String getTableName(Class<?> aClass) {
        final Entity[] annotationsByType = aClass.getAnnotationsByType(Entity.class);

        if (annotationsByType.length == 0) throw new UnsupportedOperationException(CLASS_MUST_BE_ENTITY_MESSAGE);

        return annotationsByType[0].name();
    }

    private List<EntityManager.KeyValuePair> getKeyValuePairs(E entity) {
        final Class<?> aClass = entity.getClass();

        return Arrays.stream(aClass.getDeclaredFields())
                .filter(f -> !f.isAnnotationPresent(Id.class) && f.isAnnotationPresent(Column.class))
                .map(f -> new EntityManager.KeyValuePair(f.getAnnotationsByType(Column.class)[0].name(),
                        mapFieldsToGivenType(f, entity)))
                .collect(Collectors.toList());
    }

    private String mapFieldsToGivenType(Field field, E entity) {
        field.setAccessible(true);

        Object o = null;
        try {
            o = field.get(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return o instanceof String || o instanceof LocalDate
                ? "'" + o + "'"
                : Objects.requireNonNull(o).toString();
    }

    public record KeyValuePair(String key, String value) {
    }
}
