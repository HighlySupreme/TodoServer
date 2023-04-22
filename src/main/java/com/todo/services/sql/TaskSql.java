package com.todo.services.sql;

public interface TaskSql {


    String INSERT_TASK = "INSERT into todo.Task (title, person, description, createdDate) values (:title, :person, :description, now())";
    String UPDATE_TASK = "UPDATE todo.Task SET title = :title, person = :person, description = :description WHERE id = :id";
    String GET_TASKS = "SELECT id, title, person, description, createdDate from todo.Task";
    String GET_TASK = "SELECT tt.id, tt.title, tt.person, tt.description, tt.createdDate from todo.Task tt where tt.id = :id";
    String DELETE_TASK = "DELETE from todo.Task where id = :id";

}
