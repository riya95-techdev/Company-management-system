package com.lanos.organization_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lanos.organization_service.entity.Organization;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	Optional<Organization> findByCode(String code);
}
