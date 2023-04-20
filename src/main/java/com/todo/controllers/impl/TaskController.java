package com.todo.controllers.impl;

import com.todo.controllers.ITaskController;
import com.todo.model.Task;
import io.micronaut.http.annotation.Controller;

import java.util.List;

@Controller("/")
public class TaskController implements ITaskController {

    @Override
    public List<Task> getTasks() {
        return null;
    }
}
