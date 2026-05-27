package com.lanos.organization_service.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lanos.organization_service.department.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	boolean existsByCode(String code);
}
