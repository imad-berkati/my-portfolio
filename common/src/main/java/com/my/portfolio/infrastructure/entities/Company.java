package com.my.portfolio.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "companies", schema = "myportfolio")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Company extends BaseEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 50)
  private String industry;

  @Column(nullable = false, length = 50)
  private String department;

  @Column(name = "logo_url", nullable = false)
  private String logoUrl;

  @Column(nullable = false, length = 50)
  private String city;

  @Column(nullable = false, length = 50)
  private String country;

  @Column(columnDefinition = "TEXT")
  private String address;

  @Column(length = 20)
  private String phone;

  @Column(length = 100)
  private String email;

  @Column(length = 100)
  private String website;
}
