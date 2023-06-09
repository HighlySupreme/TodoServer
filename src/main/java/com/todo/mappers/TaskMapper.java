package com.todo.mappers;

import com.todo.model.Task;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {


    @Override
    public Task map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Task(
                rs.getInt("id"),
                rs.getString("title"),
                Date.valueOf(rs.getString("createdDate")),
                rs.getString("person"),
                rs.getString("description")
        );
    }
}