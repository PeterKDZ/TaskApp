package com.example.taskapp.repository.task;

import com.example.taskapp.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
