package com.example.taskapp.repositories.task;

import com.example.taskapp.entities.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
