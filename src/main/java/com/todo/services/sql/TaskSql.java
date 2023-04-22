package com.todo.services.sql;

public interface TaskSql {


    String INSERT_TASK = "insert into todo.Task (title, person, description, createdDate) values (:title, :person, :description, now())";

    String GET_TASKS = "select id, title, person, description, createdDate from todo.Task";

}
