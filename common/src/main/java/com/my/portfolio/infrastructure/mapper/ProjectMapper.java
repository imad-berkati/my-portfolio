package com.my.portfolio.infrastructure.mapper;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.infrastructure.entities.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectDto toDto(Project project);
}
