package com.lanos.organization_service.mapper;

import com.lanos.organization_service.dto.OrganizationRequestDto;
import com.lanos.organization_service.dto.OrganizationResponseDto;
import com.lanos.organization_service.entity.Organization;

public class OrganizationMapper {
	public static Organization toEntity(OrganizationRequestDto dto) {

        Organization organization = new Organization();

        organization.setCode(dto.getCode());
        organization.setName(dto.getName());
        organization.setActive(dto.getActive());

        return organization;
    }

    public static OrganizationResponseDto toDto(Organization organization) {

        OrganizationResponseDto dto = new OrganizationResponseDto();

        dto.setId(organization.getId());
        dto.setCode(organization.getCode());
        dto.setName(organization.getName());
        dto.setActive(organization.getActive());

        return dto;
    }
}
