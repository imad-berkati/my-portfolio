package com.my.portfolio.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "projects_skills", schema = "myportfolio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProjectSkill implements Serializable {

  @EmbeddedId private ProjectSkillId id;

  @MapsId("projectId")
  @ManyToOne
  @JoinColumn(name = "project_id")
  private Project project;

  @MapsId("skillId")
  @ManyToOne
  @JoinColumn(name = "skill_id")
  private Skill skill;

  @Column(name = "skill_priority")
  private Long skillPriority;

  @Column(name = "usage_percentage", precision = 5, scale = 2)
  private BigDecimal usagePercentage;
}
