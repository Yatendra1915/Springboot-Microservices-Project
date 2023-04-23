package com.microservice.employeeservice.service.impl;

import com.microservice.employeeservice.DTO.APIResponseDto;
import com.microservice.employeeservice.DTO.DepartmentDTO;
import com.microservice.employeeservice.DTO.EmployeeDTO;
import com.microservice.employeeservice.DTO.OrganizationDTO;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.APICilent;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate
    private WebClient webClient;

    private APICilent apiCilent;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getLastName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode(),
                employeeDTO.getOrganizationCode()
        );
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDTO savedEmployeeDto = new EmployeeDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastNmae(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode(),
                savedEmployee.getOrganizationCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DepartmentDTO> responseEntity=restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(),DepartmentDTO.class);
//
//        DepartmentDTO departmentDTO = responseEntity.getBody();

//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/departments/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

        OrganizationDTO organizationDTO = webClient.get()
                .uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode()).retrieve()
                .bodyToMono(OrganizationDTO.class).block();


        DepartmentDTO departmentDTO = apiCilent.getDepartment(employee.getDepartmentCode());
        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastNmae(),
                employee.getEmail(),
                employee.getDepartmentCode(),
                employee.getOrganizationCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDTO(employeeDTO);
        apiResponseDto.setDepartmentDTO(departmentDTO);
        apiResponseDto.setOrganizationDTO(organizationDTO);

        return apiResponseDto;
    }
}
