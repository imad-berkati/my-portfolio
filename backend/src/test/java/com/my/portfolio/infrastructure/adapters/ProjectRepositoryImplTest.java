package com.my.portfolio.infrastructure.adapters;

import static org.assertj.core.api.Assertions.assertThat;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import com.my.portfolio.infrastructure.PostgresTestContainer;
import com.my.portfolio.infrastructure.entities.Project;
import com.my.portfolio.infrastructure.mapper.ProjectMapper;
import com.my.portfolio.infrastructure.repositories.ProjectJpaRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ProjectRepositoryImplTest extends PostgresTestContainer {

  @Autowired private ProjectJpaRepository projectJpaRepository;

  private ProjectRepository projectRepository;

  @Autowired private ProjectMapper projectMapper;

  @BeforeEach
  void init() {
    projectRepository = new ProjectRepositoryImpl(projectJpaRepository, projectMapper);
    projectJpaRepository.save(Project.builder().name("test-project").build());
  }

  @Test
  public void getProjectById_ShouldReturnProjectDto_WhenProjectExists() {
    Optional<ProjectDto> projectDtoOptional = projectRepository.getProjectById(1L);
    assertThat(projectDtoOptional).isNotEmpty();
    ProjectDto projectDto = projectDtoOptional.get();
    assertThat(projectDto.getId()).isEqualTo(1L);
    assertThat(projectDto.getName()).isEqualTo("test-project");
    assertThat(projectDto.getCreatedAt()).isNotNull();
    assertThat(projectDto.getUpdatedAt()).isNotNull();
  }

  @Test
  public void getProjectById_ShouldReturnEmpty_WhenProjectDoesNotExist() {
    Optional<ProjectDto> projectDtoOptional = projectRepository.getProjectById(200L);
    assertThat(projectDtoOptional).isEmpty();
  }
}
