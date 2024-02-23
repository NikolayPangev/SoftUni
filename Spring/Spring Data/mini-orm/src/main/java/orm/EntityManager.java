package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public Iterable find(Class table) throws SQLException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        final String tableName = getTableName(table);

        final PreparedStatement findFirstStatement = connection.prepareStatement(String.format(FIND_ALL_QUERY, tableName));

        return getPOJOs(findFirstStatement, table);
    }


    @Override
    public Iterable<E> find(Class<E> table, String condition) throws SQLException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {

        final String tableName = getTableName(table);
        final String finalCondition = condition != null
                ? WHERE_KEY_WORD + condition
                : "";

        final PreparedStatement findFirstStatement =
                connection.prepareStatement(String.format(FIND_ALL_WITH_CONDITION_QUERY, tableName, finalCondition));

        return getPOJOs(findFirstStatement, table);

    }

    @Override
    public Object findFirst(Class table) throws SQLException,
            InvocationTargetException,
            NoSuchMethodException,
            InstantiationException,
            IllegalAccessException {
        final String tableName = getTableName(table);

        final PreparedStatement findFirstStatement =
                connection.prepareStatement(String.format(FIND_FIRST_QUERY, tableName));

        return getPOJO(findFirstStatement, table);
    }



    @Override
    public Object findFirst(Class table, String where) {
        return null;
    }

    private Field getIdColumn(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(Id.class))
                .findFirst().orElseThrow(() -> new UnsupportedOperationException(ID_COLUM_MISSING_MESSAGE));
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
                        mapFieldsToGivenType(f, entity))).collect(Collectors.toList());
    }

    private String mapFieldsToGivenType(Field field, E entity) {
        field.setAccessible(true);

        Object o = null;
        try {
            o = field.get(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return o instanceof String || o instanceof LocalDate ? "'" + o + "'" : Objects.requireNonNull(o).toString();
    }

    private E getPOJO(PreparedStatement findFirstStatement, Class<E> table) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        final ResultSet resultSet = findFirstStatement.executeQuery();
        resultSet.next();

        final E entity = table.getDeclaredConstructor().newInstance();

        fillEntity(table, resultSet, entity);

        return entity;
    }

    private Iterable<E> getPOJOs(PreparedStatement findFirstStatement, Class<E> table) throws SQLException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        final ResultSet resultSet = findFirstStatement.executeQuery();

        List<E> entities = new ArrayList<>();

        while (resultSet.next()) {
            final E entity = table.getDeclaredConstructor().newInstance();

            fillEntity(table, resultSet, entity);

            entities.add(entity);
        }

        return entities;
    }

    private void fillEntity(Class<E> table, ResultSet resultSet, E entity) {
        Arrays.stream(table.getDeclaredFields()).forEach(field -> fillFiled(field, resultSet, entity));
    }

    private void fillFiled(Field field, ResultSet resultSet, E entity) {
        final Class<?> type = field.getType();
        field.setAccessible(true);

        try {
            if (type == int.class || type == long.class) {
                field.set(entity, resultSet.getInt(field.getName()));
                return;
            } else if (type == LocalDate.class) {
                field.set(entity, LocalDate.parse(resultSet.getString(field.getName())));
                return;
            }

            field.set(entity, resultSet.getString(field.getName()));
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public record KeyValuePair(String key, String value) {
    }
}
