package com.example.petcare.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode
public abstract class BaseServiceRoleProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private String city;

    @SuperBuilder.Default
    @Column(name = "experience_years", nullable = false, columnDefinition = "integer default 0")
    private Integer experienceYears = 0;

    @SuperBuilder.Default
    @Column(nullable = false, precision = 3, scale = 2, columnDefinition = "decimal(3,2) default 0")
    private BigDecimal rating = BigDecimal.ZERO;

    @SuperBuilder.Default
    @Column(name = "reviews_count", nullable = false, columnDefinition = "integer default 0")
    private Integer reviewsCount = 0;

    @SuperBuilder.Default
    @ElementCollection
    @CollectionTable(name = "service_role_profile_services", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "service_name")
    private List<String> services = new ArrayList<>();
}
