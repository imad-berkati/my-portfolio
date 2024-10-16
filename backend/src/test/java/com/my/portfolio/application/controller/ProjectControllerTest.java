package com.my.portfolio.application.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.my.portfolio.ControllerTest;
import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.exception.NotFoundException;
import com.my.portfolio.domain.ports.application.ProjectService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

class ProjectControllerTest extends ControllerTest {

  public static final String PROJECT_URL = API_V1 + "/projects";

  @MockBean private ProjectService projectService;

  @Test
  public void getProjectById_ShouldReturnProjectDto_WhenProjectExists() throws Exception {

    ProjectDto mockProjectDto = new ProjectDto();
    mockProjectDto.setId(1L);
    mockProjectDto.setName("test-project");
    mockProjectDto.setCreatedAt(LocalDateTime.now());
    mockProjectDto.setUpdatedAt(LocalDateTime.now());

    when(projectService.getProjectById(1L)).thenReturn(mockProjectDto);

    mockMvc
        .perform(get(PROJECT_URL + "/1").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1L))
        .andExpect(jsonPath("$.name").value("test-project"))
        .andExpect(jsonPath("$.createdAt").isNotEmpty())
        .andExpect(jsonPath("$.updatedAt").isNotEmpty());

    verify(projectService, times(1)).getProjectById(1L);
  }

  @Test
  public void getProjectById_ShouldReturn404_WhenProjectDoesNotExists() throws Exception {

    when(projectService.getProjectById(1L))
        .thenThrow(new NotFoundException("Project 1 doesn't exist"));

    mockMvc
        .perform(
            get(PROJECT_URL + "/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("Project 1 doesn't exist"))
        .andExpect(jsonPath("$.status").value("404"))
        .andExpect(jsonPath("$.timestamp").isNotEmpty());

    verify(projectService, times(1)).getProjectById(1L);
  }
}
