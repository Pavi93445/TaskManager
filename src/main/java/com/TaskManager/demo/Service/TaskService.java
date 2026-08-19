package com.TaskManager.demo.Service;

import com.TaskManager.demo.Entity.TaskEntity;
import com.TaskManager.demo.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public TaskEntity createTask(TaskEntity task){
        return taskRepository.save(task);
    }

    public List<TaskEntity>getAllTasks(){
        return taskRepository.findAll();
    }

    public TaskEntity getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteTaskById(Long id){
         taskRepository.deleteById(id);
    }
    public TaskEntity updateTask(Long id,TaskEntity task){
        TaskEntity existingtask = taskRepository.findById(id).orElse(null);

        if(existingtask == null){
            return null;
        }
        existingtask.setTitle(task.getTitle());
        existingtask.setDescription(task.getDescription());
        existingtask.setCompleted(task.isCompleted());

        return taskRepository.save(task);
    }
}


