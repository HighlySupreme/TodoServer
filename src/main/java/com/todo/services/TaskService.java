package com.todo.services;

import com.todo.model.Task;
import com.todo.services.dao.TaskDao;
import io.micronaut.context.annotation.Requires;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.sql.DataSource;
import java.util.List;

@Singleton
@Requires(classes = DataSource.class)
public class TaskService {
    private DataSource dataSource;

    private final DatabaseService db = new DatabaseService();
    @Inject
    public TaskService() {}

    public List<Task> getTasks() {
        return null;
    }

    public void createTask(Task task) {
        try {
            db.useExtension(TaskDao.class, dao -> dao.insertTask(task));
        } catch (Exception e) {
            //Log the error to the server with logger or anything similar
            throw new RuntimeException("ERR_CREATE_TASK");
        }
    }

}
