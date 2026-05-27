package com.lanos.organization_service.department.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanos.organization_service.department.dto.DepartmentRequestDto;
import com.lanos.organization_service.department.dto.DepartmentResponseDto;
import com.lanos.organization_service.department.entity.Department;
import com.lanos.organization_service.department.mapper.DepartmentMapper;
import com.lanos.organization_service.department.repository.DepartmentRepository;
import com.lanos.organization_service.entity.Organization;
import com.lanos.organization_service.repository.OrganizationRepository;

@Service
public class DepartmentServiceImple implements DepartmentServiceInterface{

	@Autowired
	public DepartmentRepository departmentRepository;
	@Autowired
	public OrganizationRepository organizationRepository;
	
	public DepartmentServiceImple(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.organizationRepository = organizationRepository;
	}
	
	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
		
		if(departmentRepository.existsByCode(dto.getCode())) {
			throw new RuntimeException("Department Code Already exists.");
		}
		
		Organization organization= organizationRepository.findById(dto.getOrganizationId())
				.orElseThrow(()->  new RuntimeException("Organization not found"));
		
		Department department = new Department();
		
		department.setCode(dto.getCode());
		department.setName(dto.getName());
		department.setActive(dto.getActive());
		
		department.setOrganization(organization);
		
		Department savedDepartment = departmentRepository.save(department);
		
		return DepartmentMapper.mapToDto(savedDepartment);
	}
	
	@Override
    public List<DepartmentResponseDto> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {

        Department department =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Department not found"));

        return DepartmentMapper.mapToDto(department);
    }

    @Override
    public DepartmentResponseDto updateDepartment(
            Long id,
            DepartmentRequestDto dto) {

        Department department =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Department not found"));

        Organization organization =
                organizationRepository.findById(dto.getOrganizationId())
                        .orElseThrow(() ->
                                new RuntimeException("Organization not found"));

        department.setCode(dto.getCode());
        department.setName(dto.getName());
        department.setActive(dto.getActive());

        department.setOrganization(organization);

        Department updatedDepartment =
                departmentRepository.save(department);

        return DepartmentMapper.mapToDto(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department =
                departmentRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Department not found"));

        departmentRepository.delete(department);
    }
}
