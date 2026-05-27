package com.lanos.organization_service.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanos.organization_service.dto.OrganizationRequestDto;
import com.lanos.organization_service.dto.OrganizationResponseDto;
import com.lanos.organization_service.service.OrganizationService;
import com.lanos.sharedkernel.response.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/organization")
@Validated
public class OrganizationController {
	private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Organization Service Running";
    }
    
    @PostMapping
    public ApiResponse<OrganizationResponseDto>
    createOrganization(
            @Valid @RequestBody OrganizationRequestDto dto) {

        OrganizationResponseDto response =
                service.createOrganization(dto);

        return new ApiResponse<>(
                true,
                "Organization created successfully",
                response
        );
    }
    
//    @PostMapping
//    public OrganizationResponseDto createOrganization(
//            @Valid @RequestBody OrganizationRequestDto dto) {
//
//        return service.createOrganization(dto);
//    }

    @GetMapping
    public ApiResponse<List<OrganizationResponseDto>>
    getAllOrganizations() {

        return new ApiResponse<>(
                true,
                "Organizations fetched successfully",
                service.getAllOrganizations()
        );
    }
    
//    @GetMapping
//    public List<OrganizationResponseDto> getAllOrganizations() {
//
//        return service.getAllOrganizations();
//    }

    
    @GetMapping("/{id}")
    public ApiResponse<OrganizationResponseDto>
    getOrganizationById(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Organization fetched successfully",
                service.getOrganizationById(id)
        );
    }
//    @GetMapping("/{id}")
//    public OrganizationResponseDto getOrganizationById(
//            @PathVariable Long id) {
//
//        return service.getOrganizationById(id);
//    }

    
    @PutMapping("/{id}")
    public ApiResponse<OrganizationResponseDto>
    updateOrganization(
            @PathVariable Long id,
            @Valid @RequestBody OrganizationRequestDto dto) {

        return new ApiResponse<>(
                true,
                "Organization updated successfully",
                service.updateOrganization(id, dto)
        );
    }
//    @PutMapping("/{id}")
//    public OrganizationResponseDto updateOrganization(
//            @PathVariable Long id,
//            @Valid @RequestBody OrganizationRequestDto dto) {
//
//        return service.updateOrganization(id, dto);
//    }

    @DeleteMapping("/{id}")
    public ApiResponse<String>
    deleteOrganization(@PathVariable Long id) {

        service.deleteOrganization(id);

        return new ApiResponse<>(
                true,
                "Organization deleted successfully",
                null
        );
    }
    
//    @DeleteMapping("/{id}")
//    public String deleteOrganization(@PathVariable Long id) {
//
//        service.deleteOrganization(id);
//
//        return "Organization deleted successfully";
//    }
}
