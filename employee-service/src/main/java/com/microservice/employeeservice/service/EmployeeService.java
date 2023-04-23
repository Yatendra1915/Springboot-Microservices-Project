package com.microservice.employeeservice.service;

import com.microservice.employeeservice.DTO.APIResponseDto;
import com.microservice.employeeservice.DTO.EmployeeDTO;
import com.microservice.employeeservice.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    APIResponseDto getEmployeeById(Long employeeId);
}
