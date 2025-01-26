package com.my.portfolio.domain.ports.infrastructure;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

  Optional<ProjectDto> getProjectById(long id);

  List<ProjectSummaryDto> getProjectsSummaries();
}
