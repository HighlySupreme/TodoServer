package com.todo.controllers.impl;

import com.todo.controllers.ITaskController;
import com.todo.model.Task;
import com.todo.services.TaskService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/api/{api.version}/task")
public class TaskController implements ITaskController {

    @Inject
    private TaskService taskService;

    @Override
    public HttpResponse<List<Task>> getTasks() {

        try {
            List<Task> taskList = taskService.getTasks();

            if (taskList != null) {
                return HttpResponse.ok(taskList);
            }
            return HttpResponse.noContent();

        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }
}
