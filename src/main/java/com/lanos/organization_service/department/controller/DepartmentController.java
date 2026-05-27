package com.lanos.organization_service.department.controller;

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

import com.lanos.organization_service.department.dto.DepartmentRequestDto;
import com.lanos.organization_service.department.dto.DepartmentResponseDto;
import com.lanos.organization_service.department.service.DepartmentServiceInterface;
import com.lanos.sharedkernel.response.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/department")
@Validated
public class DepartmentController {
	private final DepartmentServiceInterface service;

    public DepartmentController(DepartmentServiceInterface service) {
        this.service = service;
    }

    @PostMapping
    public ApiResponse<DepartmentResponseDto>
    createDepartment(
            @Valid @RequestBody DepartmentRequestDto dto) {

        return new ApiResponse<>(
                true,
                "Department created successfully",
                service.createDepartment(dto)
        );
    }

    @GetMapping
    public ApiResponse<List<DepartmentResponseDto>>
    getAllDepartments() {

        return new ApiResponse<>(
                true,
                "Departments fetched successfully",
                service.getAllDepartments()
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<DepartmentResponseDto>
    getDepartmentById(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Department fetched successfully",
                service.getDepartmentById(id)
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<DepartmentResponseDto>
    updateDepartment(
            @PathVariable Long id,
            @Valid @RequestBody DepartmentRequestDto dto) {

        return new ApiResponse<>(
                true,
                "Department updated successfully",
                service.updateDepartment(id, dto)
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String>
    deleteDepartment(@PathVariable Long id) {

        service.deleteDepartment(id);

        return new ApiResponse<>(
                true,
                "Department deleted successfully",
                null
        );
    }
}
