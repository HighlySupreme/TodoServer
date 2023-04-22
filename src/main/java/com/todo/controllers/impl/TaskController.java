package com.todo.controllers.impl;

import com.todo.controllers.ITaskController;
import com.todo.model.Task;
import com.todo.services.TaskService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.server.cors.CrossOrigin;

import java.util.List;

@Controller("/api/{api.version}/task")
@CrossOrigin({"http://localhost:9000"})
public class TaskController implements ITaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

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

    @Override
    public HttpResponse<Task> createTask(@Body Task task) {
        try {
            if (task == null) return HttpResponse.badRequest();

            taskService.createTask(task);

            return HttpResponse.ok();

        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Override
    public HttpResponse<Task> updateTask(@Body Task task) {
        try {
            if (task == null) return HttpResponse.badRequest();

            taskService.updateTask(task);

            return HttpResponse.ok();

        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Override
    public HttpResponse<Task> getTask(int id) {
        try {
            Task task = taskService.getTask(id);

            if (task != null) {
                return HttpResponse.ok(task);
            }
            return HttpResponse.noContent();

        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    @Override
    public HttpResponse<Task> deleteTasks(List<Task> taskList) {
        try {
            if (taskList != null && !taskList.isEmpty()) {
                taskService.deleteTasks(taskList);
            }
            return HttpResponse.noContent();
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }
}
