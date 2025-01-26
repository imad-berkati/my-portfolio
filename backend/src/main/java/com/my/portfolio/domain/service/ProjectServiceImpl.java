package com.my.portfolio.domain.service;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import com.my.portfolio.domain.exception.NotFoundException;
import com.my.portfolio.domain.ports.application.ProjectService;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;

  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public ProjectDto getProjectById(long id) {
    Optional<ProjectDto> projectDtoOptional = projectRepository.getProjectById(id);
    if (projectDtoOptional.isEmpty()) {
      throw new NotFoundException("Project " + id + " doesn't exist");
    }
    return projectDtoOptional.get();
  }

  @Override
  public List<ProjectSummaryDto> getProjectsSummaries() {
    return projectRepository.getProjectsSummaries();
  }
}
