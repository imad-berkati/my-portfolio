package com.my.portfolio.infrastructure.adapters;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import com.my.portfolio.infrastructure.entities.Project;
import com.my.portfolio.infrastructure.mapper.ProjectMapper;
import com.my.portfolio.infrastructure.repositories.ProjectJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectRepositoryImpl implements ProjectRepository {

    private final ProjectJpaRepository projectJpaRepository;

    private final ProjectMapper projectMapper;

    public ProjectRepositoryImpl(ProjectJpaRepository projectJpaRepository, ProjectMapper projectMapper) {
        this.projectJpaRepository = projectJpaRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Optional<ProjectDto> getProjectById(long id) {
        Optional<Project> project = projectJpaRepository.findById(id);
        return project.map(projectMapper::toDto);
    }
}