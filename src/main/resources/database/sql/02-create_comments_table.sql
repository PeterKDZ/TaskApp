-- liquibase formatted sql
-- changeset pkedzierski:1
-- create comments table

CREATE SEQUENCE task_schema.comments_sequence;
CREATE TABLE task_schema.comments
(
    id           int NOT NULL DEFAULT nextval('task_schema.comments_sequence'::regclass),
    name         varchar(255),
    content      varchar(450),
    task_id      int,

    CONSTRAINT comments_pkey PRIMARY KEY (id)
    FOREIGN KEY (task_id) REFERENCES tasks(id)
);