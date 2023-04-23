package com.organisationservice.organisationservice.service.impl;

import com.organisationservice.organisationservice.DTO.OrganizationDTO;
import com.organisationservice.organisationservice.entity.Organization;
import com.organisationservice.organisationservice.mapper.OrganizationMapper;
import com.organisationservice.organisationservice.repository.OrganizationRepository;
import com.organisationservice.organisationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {

        // convert orgDto to org jpa entity

        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);

        Organization savedOrg = organizationRepository.save(organization);

        return  OrganizationMapper.mapToOrganizationDto(savedOrg);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {

        Organization organization = organizationRepository.findByOrganizationCode( organizationCode);

        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
