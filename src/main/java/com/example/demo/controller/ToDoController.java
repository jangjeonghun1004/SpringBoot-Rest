package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.ToDoResponseDTO;
import com.example.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService todoService) {
        this.toDoService = todoService;
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<ToDoResponseDTO>>> toDosGet() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(HttpStatus.OK, this.toDoService.findAll())
        );
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<ToDoResponseDTO>> toDosPost(@RequestBody ToDoResponseDTO toDoResponseDTO) {
        ToDoResponseDTO newToDoResponseDTO = this.toDoService.save(toDoResponseDTO);

        ApiResponse<ToDoResponseDTO> apiResponse = new ApiResponse<>(HttpStatus.OK, newToDoResponseDTO);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> todoDelete(@PathVariable Long id) {
        ApiResponse<String> apiResponse = null;

        try {
            this.toDoService.deleteById(id);
            apiResponse = new ApiResponse<>(HttpStatus.OK, "Success");
        } catch(Exception e) {
            apiResponse = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "Failed");
        }

        return ResponseEntity.ok(apiResponse);
    }

    @PatchMapping("")
    public ResponseEntity<ApiResponse<ToDoResponseDTO>> todoPatch(@RequestBody ToDoResponseDTO toDoResponseDTO) {
        ToDoResponseDTO newToDoResponseDTO = this.toDoService.update(toDoResponseDTO);
        ApiResponse<ToDoResponseDTO> apiResponse = new ApiResponse<>(HttpStatus.OK, newToDoResponseDTO);

        return ResponseEntity.ok(apiResponse);
    }



}
