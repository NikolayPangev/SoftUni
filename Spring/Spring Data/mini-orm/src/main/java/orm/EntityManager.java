package orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;

import static orm.MyConnector.getConnection;

public class EntityManager<E> implements DBContext {
    private final Connection connection;

    public EntityManager() throws SQLException {
        this.connection = getConnection();
    }

    @Override
    public boolean persist(Object entity) {
        final Field idColumn = getIdColumn(entity.getClass());
        return false;
    }

    private Field getIdColumn(Class<?> aClass) {
        return null;
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
}
