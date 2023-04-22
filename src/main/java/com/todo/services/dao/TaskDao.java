package com.todo.services.dao;

import com.todo.model.Task;
import com.todo.services.sql.TaskSql;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface TaskDao extends TaskSql {

    @SqlUpdate(INSERT_TASK)
    void insertTask(@BindBean Task task);

    @SqlUpdate(UPDATE_TASK)
    void updateTask(@BindBean Task task);

    @SqlQuery(GET_TASKS)
    List<Task> getTasks();
    @SqlQuery(GET_TASK)
    Task getTask(@Bind int id);
    @SqlBatch(DELETE_TASK)
    void deleteTask(@BindBean List<Task> taskList);


}
