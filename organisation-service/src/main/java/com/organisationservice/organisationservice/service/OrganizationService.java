package com.organisationservice.organisationservice.service;

import com.organisationservice.organisationservice.DTO.OrganizationDTO;

public interface OrganizationService {
    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    OrganizationDTO getOrganizationByCode(String organizationCode);
}
