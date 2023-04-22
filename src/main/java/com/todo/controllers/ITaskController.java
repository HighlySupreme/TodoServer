package com.todo.controllers;

import com.todo.model.Task;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/api/{api.version}/task")
public interface ITaskController {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<List<Task>> getTasks();

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Task> createTask(@Body Task task);
    @Put
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Task> updateTask(@Body Task task);
    @Get("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Task> getTask(@PathVariable int id);
    @Delete("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    HttpResponse<Task> deleteTasks(@Body List<Task> taskList);


}
