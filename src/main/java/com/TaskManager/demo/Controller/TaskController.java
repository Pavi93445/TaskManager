package com.TaskManager.demo.Controller;

import com.TaskManager.demo.Entity.TaskEntity;
import com.TaskManager.demo.Service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://task-manager-frontend-three-snowy.vercel.app"
})
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<TaskEntity> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskEntity updateTask(@PathVariable Long id,
                                 @RequestBody TaskEntity task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }
}