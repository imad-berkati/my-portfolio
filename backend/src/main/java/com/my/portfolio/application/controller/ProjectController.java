package com.my.portfolio.application.controller;

import com.my.portfolio.api.v1.ProjectsApi;
import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import com.my.portfolio.domain.ports.application.ProjectService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProjectController implements ProjectsApi {

  private final ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @Override
  public ResponseEntity<ProjectDto> getProjectById(Long id) {
    return ResponseEntity.ok(projectService.getProjectById(id));
  }

  @Override
  public ResponseEntity<List<ProjectSummaryDto>> getProjectsSummaries() {
    return ResponseEntity.ok(projectService.getProjectsSummaries());
  }
}
