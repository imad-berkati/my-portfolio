package com.my.portfolio.domain.service;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.ports.application.ProjectService;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            // TODO add custom exception and handle it in ControllerAdvice
            throw new RuntimeException("NOT FOUND PROJECT");
        }
        return projectDtoOptional.get();
    }
}
