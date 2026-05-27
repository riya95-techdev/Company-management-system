package com.lanos.organization_service.service;

import java.util.List;

import com.lanos.organization_service.dto.OrganizationRequestDto;
import com.lanos.organization_service.dto.OrganizationResponseDto;

public interface OrganizationServiceInterface {
	 OrganizationResponseDto createOrganization(OrganizationRequestDto dto);

	    List<OrganizationResponseDto> getAllOrganizations();

	    OrganizationResponseDto getOrganizationById(Long id);

	    OrganizationResponseDto updateOrganization(Long id, OrganizationRequestDto dto);

	    void deleteOrganization(Long id);
}
