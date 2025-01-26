package com.my.portfolio.infrastructure.adapters;

import static org.assertj.core.api.Assertions.assertThat;

import com.my.portfolio.api.v1.model.ProjectDto;
import com.my.portfolio.domain.ports.infrastructure.ProjectRepository;
import com.my.portfolio.infrastructure.PostgresTestContainer;
import com.my.portfolio.infrastructure.entities.Company;
import com.my.portfolio.infrastructure.entities.Project;
import com.my.portfolio.infrastructure.mapper.ProjectMapper;
import com.my.portfolio.infrastructure.repositories.CompanyJpaRepository;
import com.my.portfolio.infrastructure.repositories.ProjectJpaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ProjectRepositoryImplTest extends PostgresTestContainer {

  @Autowired private ProjectJpaRepository projectJpaRepository;

  @Autowired private CompanyJpaRepository companyJpaRepository;

  private ProjectRepository projectRepository;

  @Autowired private ProjectMapper projectMapper;

  @BeforeEach
  void init() {
    projectRepository = new ProjectRepositoryImpl(projectJpaRepository, projectMapper);
    projectJpaRepository.saveAll(buildProjects());
  }

  @Test
  public void getProjectById_ShouldReturnProjectDto_WhenProjectExists() {
    Optional<ProjectDto> projectDtoOptional = projectRepository.getProjectById(1L);
    assertThat(projectDtoOptional).isNotEmpty();
    ProjectDto projectDto = projectDtoOptional.get();
    assertThat(projectDto.getId()).isEqualTo(1L);
    assertThat(projectDto.getName()).isEqualTo("SIKAPA");
    assertThat(projectDto.getCreatedAt()).isNotNull();
    assertThat(projectDto.getUpdatedAt()).isNotNull();
  }

  @Test
  public void getProjectById_ShouldReturnEmpty_WhenProjectDoesNotExist() {
    Optional<ProjectDto> projectDtoOptional = projectRepository.getProjectById(200L);
    assertThat(projectDtoOptional).isEmpty();
  }

  private List<Project> buildProjects() {
    List<Project> projects = new ArrayList<>();

    Company enedis =
        Company.builder()
            .id(1L)
            .name("ENEDIS")
            .city("Paris")
            .country("FRANCE")
            .industry("Electricity")
            .department("ICAM")
            .logoUrl("someLogo")
            .build();
    companyJpaRepository.save(enedis);

    Project enedisSikapa =
        Project.builder()
            .id(1L)
            .company(Company.builder().id(1L).build())
            .name("SIKAPA")
            .title("TechLead & Senior Developer")
            .startDate(LocalDate.of(2023, 12, 1))
            .endDate(null)
            .summary("some summary")
            .employmentType(null)
            .locationType(null)
            .description("some description")
            .visible(true)
            .projectSkills(List.of())
            .build();

    projects.add(enedisSikapa);

    return projects;
  }
}
