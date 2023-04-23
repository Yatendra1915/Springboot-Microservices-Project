package com.microservice.employeeservice.service;

import com.microservice.employeeservice.DTO.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="DEPARTMENT-SERVICE")
public interface APICilent {

    @GetMapping("api/departments/{department-code}")
    DepartmentDTO getDepartment(@PathVariable("department-code") String departmentCode);

}
