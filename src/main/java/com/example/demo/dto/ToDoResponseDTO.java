package com.example.demo.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ToDoResponseDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("completed")
    private boolean completed;

    // 기본 생성자
    public ToDoResponseDTO() {}

    // 모든 필드를 포함하는 생성자
    public ToDoResponseDTO(Long id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    // Getter와 Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}




