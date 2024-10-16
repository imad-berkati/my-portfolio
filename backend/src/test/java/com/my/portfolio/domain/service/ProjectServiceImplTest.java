package com.my.portfolio.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.exception.NotFoundException;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

  @Mock private ProjectRepository projectRepository;

  @InjectMocks private ProjectServiceImpl projectServiceImpl;

  private ProjectDto projectDto;

  @BeforeEach
  public void setUp() {
    projectDto = new ProjectDto();
    projectDto.setId(1L);
    projectDto.setName("Test Project");
    projectDto.setCreatedAt(LocalDateTime.now());
    projectDto.setUpdatedAt(LocalDateTime.now());
  }

  @Test
  public void getProjectById_ShouldReturnProjectDto_WhenProjectExists() {
    when(projectRepository.getProjectById(1L)).thenReturn(Optional.of(projectDto));

    ProjectDto result = projectServiceImpl.getProjectById(1L);

    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(1L);
    assertThat(result.getName()).isEqualTo("Test Project");
    verify(projectRepository, times(1)).getProjectById(1L);
  }

  @Test
  public void getProjectById_ShouldThrowNotFoundException_WhenProjectDoesNotExist() {
    when(projectRepository.getProjectById(1L)).thenReturn(Optional.empty());

    NotFoundException exception =
        assertThrows(NotFoundException.class, () -> projectServiceImpl.getProjectById(1L));

    assertThat(exception.getMessage()).isEqualTo("Project 1 doesn't exist");
    verify(projectRepository, times(1)).getProjectById(1L);
  }
}
