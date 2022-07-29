package com.example.taskapp.enums.task;

public enum Status {
    TO_DO("Task to do, not started yet"),
    IN_PROGRESS("Started task, during the process"),
    DONE("Finished task");

    Status(String description) {
    }
}
