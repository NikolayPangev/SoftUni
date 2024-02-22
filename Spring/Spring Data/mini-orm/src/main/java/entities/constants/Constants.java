package entities.constants;

public enum Constants {
    ;
    public static final String ID_COLUM_MISSING_MESSAGE = "Entity missing an Id column";
    public static final String CLASS_MUST_BE_ENTITY_MESSAGE = "Class must be Entity";
    public static final String COMMA_SEPARATOR = ", ";

    public enum Queries {
        ;
        public static final String INSET_QUERY_FORMAT = "INSERT INTO %s (%s) VALUES (%s)";
        public static final String UPDATE_QUERY_BY_ID_FORMAT = "UPDATE %s e SET %s WHERE e.id = %d";
        public static final String FIND_ALL_QUERY = "SELECT * FROM %s";
        public static final String CREATE_VALUE_FORMAT = "%s %s";

        public static final String UPDATE_VALUE_FORMAT = "%s = %s";
    }
}
