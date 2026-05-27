package com.lanos.organization_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanos.organization_service.dto.OrganizationRequestDto;
import com.lanos.organization_service.dto.OrganizationResponseDto;
import com.lanos.organization_service.entity.Organization;
import com.lanos.organization_service.exception.ResourceNotFoundException;
import com.lanos.organization_service.mapper.OrganizationMapper;
import com.lanos.organization_service.repository.OrganizationRepository;

@Service
public class OrganizationService implements OrganizationServiceInterface{
	
	private final OrganizationRepository repository;

    public OrganizationService(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrganizationResponseDto createOrganization(OrganizationRequestDto dto) {

        Organization organization = OrganizationMapper.toEntity(dto);

        Organization saved = repository.save(organization);

        return OrganizationMapper.toDto(saved);
    }

    @Override
    public List<OrganizationResponseDto> getAllOrganizations() {

        return repository.findAll()
                .stream()
                .map(OrganizationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrganizationResponseDto getOrganizationById(Long id) {

        Organization organization = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Organization not found"));

        return OrganizationMapper.toDto(organization);
    }

    @Override
    public OrganizationResponseDto updateOrganization(Long id,
                                                      OrganizationRequestDto dto) {

        Organization organization = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Organization not found"));

        organization.setCode(dto.getCode());
        organization.setName(dto.getName());
        organization.setActive(dto.getActive());

        Organization updated = repository.save(organization);

        return OrganizationMapper.toDto(updated);
    }

    @Override
    public void deleteOrganization(Long id) {

        Organization organization = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Organization not found"));

        repository.delete(organization);
    }
}
