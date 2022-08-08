package com.example.taskapp.repository.task;

import com.example.taskapp.entity.task.Task;
import com.example.taskapp.enums.task.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllByNameAndStatus(String name, Status status);

    boolean existsTaskByNameAndStatus(String name, Status status);
}
