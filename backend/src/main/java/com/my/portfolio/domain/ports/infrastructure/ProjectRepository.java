package com.my.portfolio.domain.ports.infrastructure;

import com.my.portfolio.api.v1.model.ProjectDto;

import java.util.Optional;

public interface ProjectRepository {

    Optional<ProjectDto> getProjectById(long id);
}
