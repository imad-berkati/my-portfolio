package com.my.portfolio.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "projects", schema = "myportfolio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Project extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "company_id", referencedColumnName = "id")
  private Company company;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 100)
  private String title;

  @Column(name = "start_date", nullable = false)
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  @Column(nullable = false, columnDefinition = "TEXT")
  private String summary;

  @Column(name = "employment_type", length = 50)
  private String employmentType;

  @Column(name = "location_type", length = 50)
  private String locationType;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
  private Boolean visible = true;

  @OneToMany(mappedBy = "project")
  List<ProjectSkill> projectSkills;
}
