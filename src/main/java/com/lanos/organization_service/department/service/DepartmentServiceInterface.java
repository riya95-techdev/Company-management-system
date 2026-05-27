package com.lanos.organization_service.department.service;

import java.util.List;

import com.lanos.organization_service.department.dto.DepartmentRequestDto;
import com.lanos.organization_service.department.dto.DepartmentResponseDto;

public interface DepartmentServiceInterface {
	DepartmentResponseDto createDepartment(
            DepartmentRequestDto dto);

    List<DepartmentResponseDto> getAllDepartments();

    DepartmentResponseDto getDepartmentById(Long id);

    DepartmentResponseDto updateDepartment(
            Long id,
            DepartmentRequestDto dto);

    void deleteDepartment(Long id);
}
