package com.example.demo.service;

import com.example.demo.dto.ToDoResponseDTO;
import com.example.demo.entity.ToDoEntity;

import java.util.List;
import java.util.Optional;

public interface ToDoService {
    List<ToDoResponseDTO> findAll();
    Optional<ToDoEntity> findById(Long id);
    ToDoResponseDTO save(ToDoResponseDTO toDoResponseDTO);
    void deleteById(Long id);
    ToDoResponseDTO update(ToDoResponseDTO toDoResponseDTO);
}
