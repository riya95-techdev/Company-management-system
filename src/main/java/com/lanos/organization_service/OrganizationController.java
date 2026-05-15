package com.lanos.organization_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @GetMapping("/hello")
    public String hello(){
        return "Organization Service Running";
    }
}
