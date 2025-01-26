package com.my.portfolio.infrastructure.repositories;

import com.my.portfolio.infrastructure.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJpaRepository extends JpaRepository<Company, Long> {}
