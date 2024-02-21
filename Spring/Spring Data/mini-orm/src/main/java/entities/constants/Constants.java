package entities.constants;

public enum Constants {
    ;
    public static final String ID_COLUM_MISSING_MESSAGE = "Entity missing an Id column";
    public static final String COMMA_SEPARATOR = ", ";

    public enum Queries {
        ;
        public static final String INSET_QUERY_FORMAT = "INSERT INTO %s (%s) VALUES (%s)";
    }
}
