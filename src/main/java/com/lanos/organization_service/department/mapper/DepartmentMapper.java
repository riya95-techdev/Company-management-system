package com.lanos.organization_service.department.mapper;

import com.lanos.organization_service.department.dto.DepartmentResponseDto;
import com.lanos.organization_service.department.entity.Department;

public class DepartmentMapper {
	public static DepartmentResponseDto mapToDto(
            Department department) {

        DepartmentResponseDto dto =
                new DepartmentResponseDto();

        dto.setId(department.getId());
        dto.setCode(department.getCode());
        dto.setName(department.getName());
        dto.setActive(department.getActive());

        dto.setOrganizationId(
                department.getOrganization().getId());

        dto.setOrganizationName(
                department.getOrganization().getName());

        return dto;
    }
}
