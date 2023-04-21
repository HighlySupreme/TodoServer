package com.todo.services;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.HandleConsumer;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.extension.ExtensionCallback;
import org.jdbi.v3.core.extension.ExtensionConsumer;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;


import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseService {

    private DataSource dataSource;
    private Jdbi jdbi;

    public DatabaseService() {
        try {
            dataSource = new DataSource();
            dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
            dataSource.setUrl("jdbc:mariadb://localhost:3306/todo");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setMaxActive(10);
            jdbi = Jdbi.create(dataSource);
            jdbi.installPlugin(new SqlObjectPlugin());
        } catch (Exception e) {
            //Log the error
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public Jdbi getDbi() {
        return jdbi;
    }
    private Handle getHandle() {
        return getDbi().open();
    }

    public Handle handle() {
        return getHandle();
    }

    public <R, E, X extends Exception> R withExtension(Class<E> extensionType, ExtensionCallback<R, E, X> callback) throws X {
        return jdbi.withExtension(extensionType, callback);
    }

    public <E, X extends Exception> void useExtension(Class<E> extensionType, ExtensionConsumer<E, X> callback) throws X {
        jdbi.useExtension(extensionType, callback);
    }

    public <T extends Exception> void useHandle(HandleConsumer<T> handleConsumer) throws T{
        jdbi.useHandle(handleConsumer);
    }

}
