package com.lanos.organization_service.dto;

import jakarta.validation.constraints.NotBlank;

public class OrganizationRequestDto {
	 @NotBlank(message = "Code is required")
	    private String code;

	    @NotBlank(message = "Name is required")
	    private String name;

	    private Boolean active;

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
}
