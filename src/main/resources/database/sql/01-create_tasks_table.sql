-- liquibase formatted sql
-- changeset pkedzierski:1
-- create first task table

CREATE SEQUENCE task_schema.tasks_sequence;
CREATE TABLE task_schema.tasks
(
    id           int NOT NULL DEFAULT nextval('task_schema.tasks_sequence'::regclass),
    name         varchar(255),
    status       varchar(100),
    priority     varchar(100),
    description  text,

    CONSTRAINT tasks_pkey PRIMARY KEY (id)
);