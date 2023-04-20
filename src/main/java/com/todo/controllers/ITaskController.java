package com.todo.controllers;

import com.todo.model.Task;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/api/{api.version}/task")
public interface ITaskController {

    @Get("/")
    List<Task> getTasks();


}
