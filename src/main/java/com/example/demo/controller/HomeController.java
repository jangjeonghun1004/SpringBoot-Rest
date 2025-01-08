package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public ResponseEntity<ApiResponse<String>> home() {
        ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.OK, "success");
        return ResponseEntity.ok(apiResponse);
    }
}
