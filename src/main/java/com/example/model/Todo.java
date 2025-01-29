package com.example.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Todo {
    private UUID id;
    private String title;
    private String description;
    private boolean completed;

    public Todo() {
        // Jackson deserialization
    }

    public Todo(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    @JsonProperty
    public UUID getId() {
        return id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty
    public boolean isCompleted() {
        return completed;
    }

    @JsonProperty
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
} 