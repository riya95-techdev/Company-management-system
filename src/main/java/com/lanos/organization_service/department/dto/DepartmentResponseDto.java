package com.lanos.organization_service.department.dto;

public class DepartmentResponseDto {
	 private Long id;

	    private String code;

	    private String name;

	    private Boolean active;

	    private Long organizationId;

	    private String organizationName;

	    public DepartmentResponseDto() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getCode() {
	        return code;
	    }

	    public void setCode(String code) {
	        this.code = code;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Boolean getActive() {
	        return active;
	    }

	    public void setActive(Boolean active) {
	        this.active = active;
	    }

	    public Long getOrganizationId() {
	        return organizationId;
	    }

	    public void setOrganizationId(Long organizationId) {
	        this.organizationId = organizationId;
	    }

	    public String getOrganizationName() {
	        return organizationName;
	    }

	    public void setOrganizationName(String organizationName) {
	        this.organizationName = organizationName;
	    }
}
