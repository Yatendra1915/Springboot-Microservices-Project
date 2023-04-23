package com.microservice.departmentservice.controller;

import com.microservice.departmentservice.DTO.DepartmentDTO;
import com.microservice.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // build save department api

    @PostMapping
   public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDto){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
   }

    // build get department api

    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDTO departmentDTO=departmentService.getDepartmentByCode(departmentCode);
        return  new ResponseEntity<>(departmentDTO,HttpStatus.CREATED);
    }


}
