package com.TaskManager.demo.Repository;

import com.TaskManager.demo.Entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {

}
