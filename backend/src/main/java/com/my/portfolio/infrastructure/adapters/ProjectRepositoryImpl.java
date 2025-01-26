package com.my.portfolio.infrastructure.adapters;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import com.my.portfolio.infrastructure.entities.Project;
import com.my.portfolio.infrastructure.mapper.ProjectMapper;
import com.my.portfolio.infrastructure.repositories.ProjectJpaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProjectRepositoryImpl implements ProjectRepository {

  private final ProjectJpaRepository projectJpaRepository;

  private final ProjectMapper projectMapper;

  public ProjectRepositoryImpl(
      ProjectJpaRepository projectJpaRepository, ProjectMapper projectMapper) {
    this.projectJpaRepository = projectJpaRepository;
    this.projectMapper = projectMapper;
  }

  @Override
  public Optional<ProjectDto> getProjectById(long id) {
    Optional<Project> project = projectJpaRepository.findById(id);
    return project.map(projectMapper::toDto);
  }

  @Override
  public List<ProjectSummaryDto> getProjectsSummaries() {
    List<Project> projects = projectJpaRepository.findAll();
    return projectMapper.toSummaryDtoList(projects);
  }
}
