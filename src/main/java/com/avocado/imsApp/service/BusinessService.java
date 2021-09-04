package com.avocado.imsApp.service;

import com.avocado.imsApp.dto.BusinessRequest;
import com.avocado.imsApp.dto.BusinessResponse;
import com.avocado.imsApp.dto.UserResponse;
import com.avocado.imsApp.exception.ImsAppException;
import com.avocado.imsApp.model.Business;
import com.avocado.imsApp.repository.BusinessRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BusinessService {

    private final BusinessRepository businessRepository;


    @Transactional(readOnly = true)
    public BusinessResponse getBusinessById(int businessId){
        Optional<Business> businessOptional = this.businessRepository.findById(businessId);
        businessOptional.orElseThrow(() -> new ImsAppException("Business with ID" + businessId + " not found"));
        Business business = businessOptional.get();
        return this.mapToDto(business);
    }

    @Transactional(readOnly = true)
    public List<BusinessResponse> getAllBusinesses(){
        List<Business> businessList = this.businessRepository.findAll();
        return businessList.stream().map(this::mapToDto).collect(Collectors.toList());
    }


    @Transactional
    public void createNewBusiness(BusinessRequest businessRequest) {
        Business business = this.mapDtoToBusiness(businessRequest);
        this.businessRepository.save(business);
    }

    @Transactional
    public BusinessResponse updateBusiness(int businessId, BusinessRequest businessRequest){
        Optional<Business> businessOptional = this.businessRepository.findById(businessId);
        businessOptional.orElseThrow(() -> new ImsAppException("Business with ID" + businessId + " not found"));
        Business business = businessOptional.get();
        business.setBusinessName(businessRequest.getBusinessName());
        business.setBusinessShortName(businessRequest.getBusinessShortName());
        this.businessRepository.save(business);
        return this.mapToDto(business);
    }


    @Transactional
    public void deleteBusiness(int businessId){
        Optional<Business> businessOptional = this.businessRepository.findById(businessId);
        businessOptional.orElseThrow(() -> new ImsAppException("Business with ID" + businessId + " not found"));
        Business business = businessOptional.get();
        this.businessRepository.delete(business);
    }

    private Business mapDtoToBusiness(BusinessRequest businessRequest) {
        return Business.builder()
                .businessName(businessRequest.getBusinessName())
                .businessShortName(businessRequest.getBusinessShortName())
                .build();
    }

    private BusinessResponse mapToDto(Business business) {
        return BusinessResponse.builder()
                .businessName(business.getBusinessName())
                .businessShortName(business.getBusinessShortName())
                .createdDate(business.getCreatedDate().toEpochMilli())
                .updatedDate(business.getUpdatedDate().toEpochMilli())
                .createdBy(business.getCreatedBy())
                .updatedBy(business.getUpdatedBy())
                .users(new ArrayList<UserResponse>())
                .build();
    }
}
