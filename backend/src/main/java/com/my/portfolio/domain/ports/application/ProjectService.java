package com.my.portfolio.domain.ports.application;

import com.my.portfolio.api.v1.model.ProjectDto;

public interface ProjectService {

    ProjectDto getProjectById(long id);
}
