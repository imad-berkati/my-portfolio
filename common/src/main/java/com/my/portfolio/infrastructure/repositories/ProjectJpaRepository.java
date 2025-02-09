package com.my.portfolio.infrastructure.repositories;

import com.my.portfolio.infrastructure.entities.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectJpaRepository extends JpaRepository<Project, Long> {

  List<Project> findAllByOrderByStartDateDesc();
}
