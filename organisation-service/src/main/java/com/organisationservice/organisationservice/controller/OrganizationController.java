package com.organisationservice.organisationservice.controller;

import com.organisationservice.organisationservice.DTO.OrganizationDTO;
import com.organisationservice.organisationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    // build save org api
    @PostMapping
    public ResponseEntity<OrganizationDTO> saveOrganization(@RequestBody OrganizationDTO organizationDTO){
        OrganizationDTO savedOrg =organizationService.saveOrganization(organizationDTO);
        return new ResponseEntity<>(savedOrg, HttpStatus.CREATED);
    }

    // build get org api

    @GetMapping("{code}")
    public ResponseEntity<OrganizationDTO> getOrganization(@PathVariable("code") String organizationCode){

        OrganizationDTO organizationDTO = organizationService.getOrganizationByCode(organizationCode);

        return ResponseEntity.ok(organizationDTO);
    }
}
