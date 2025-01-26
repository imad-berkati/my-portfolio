package com.my.portfolio.infrastructure.mapper;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSkillDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import com.my.portfolio.infrastructure.entities.Project;
import com.my.portfolio.infrastructure.entities.ProjectSkill;
import java.util.Comparator;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

  ProjectDto toDto(Project project);

  @Mapping(target = "topSkills", expression = "java(getTopSkills(project.getProjectSkills()))")
  ProjectSummaryDto toSummaryDto(Project project);

  List<ProjectSummaryDto> toSummaryDtoList(List<Project> projects);

  @Mapping(target = "skill.id", source = "skill.id")
  @Mapping(target = "skill.name", source = "skill.name")
  ProjectSkillDto toProjectSkillDto(ProjectSkill projectSkill);

  List<ProjectSkillDto> toProjectSkillDtoList(List<ProjectSkill> projectSkills);

  default List<ProjectSkillDto> getTopSkills(List<ProjectSkill> projectSkills) {
    return projectSkills.stream()
        .sorted(
            Comparator.comparing(
                ProjectSkill::getSkillPriority, Comparator.nullsLast(Long::compareTo)))
        .limit(5)
        .map(this::toProjectSkillDto)
        .toList();
  }
}
