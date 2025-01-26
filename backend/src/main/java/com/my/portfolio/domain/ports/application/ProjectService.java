package com.my.portfolio.domain.ports.application;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.api.v1.model.ProjectSummaryDto;
import java.util.List;

public interface ProjectService {

  ProjectDto getProjectById(long id);

  List<ProjectSummaryDto> getProjectsSummaries();
}
