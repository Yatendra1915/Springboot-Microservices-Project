package com.organisationservice.organisationservice.mapper;

import com.organisationservice.organisationservice.DTO.OrganizationDTO;
import com.organisationservice.organisationservice.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapToOrganizationDto(Organization organization){

        OrganizationDTO organizationDTO = new OrganizationDTO(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationCode(),
                organization.getOrganizationCreatedDate()
        );

        return  organizationDTO;
    }

    public static Organization mapToOrganization(OrganizationDTO organizationDTO){

        Organization organization = new Organization(
                organizationDTO.getId(),
                organizationDTO.getOrganizationName(),
                organizationDTO.getOrganizationDescription(),
                organizationDTO.getOrganizationCode(),
                organizationDTO.getOrganizationCreatedDate()
        );

        return organization;
    }
}
