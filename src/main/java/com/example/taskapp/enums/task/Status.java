package com.example.taskapp.enums.task;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    TO_DO("TO_DO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE"),
    //TO_DO("Task to do, not started yet"),
    //IN_PROGRESS("Started task, during the process"),
    //DONE("Finished task"),

    UNKNOWN_VERSION(null);

    private final String description;

    Status(String description) {
        this.description = description;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(description);
    }
}
