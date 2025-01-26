package com.my.portfolio.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class ProjectSkillId implements Serializable {

  @Column(name = "project_id")
  private Long projectId;

  @Column(name = "skill_id")
  private Long skillId;
}
