package com.my.portfolio.application.controller;

import com.my.portfolio.api.v1.ProjectsApi;
import com.my.portfolio.api.v1.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProjectController implements ProjectsApi {

    @Override
    public ResponseEntity<Project> getProjectById(Integer id) {
        return ResponseEntity.ok(Project.builder().build());
    }
}
