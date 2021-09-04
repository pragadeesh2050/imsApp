package com.avocado.imsApp.controllers;


import com.avocado.imsApp.dto.BusinessRequest;
import com.avocado.imsApp.dto.BusinessResponse;
import com.avocado.imsApp.service.BusinessService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/businesses")
@AllArgsConstructor
public class BusinessController {


    private final BusinessService businessService;

    @GetMapping("/{businessId}")
    public ResponseEntity<BusinessResponse> getBusinessByID(@PathVariable("businessId") int businessId){
        BusinessResponse businessResponse = this.businessService.getBusinessById(businessId);
        return new ResponseEntity<BusinessResponse>(businessResponse,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BusinessResponse>> getBusinesses(){
        List<BusinessResponse> businessResponseList = this.businessService.getAllBusinesses();
        return new ResponseEntity<List<BusinessResponse>>(businessResponseList,HttpStatus.OK);
    }

    @PutMapping("/{businessId}")
    public ResponseEntity<BusinessResponse> updateBusiness(@PathVariable("businessId") int businessId,
                                                           @RequestBody BusinessRequest businessRequest){
        BusinessResponse businessResponse = this.businessService.updateBusiness(businessId,businessRequest);
        return new ResponseEntity<>(businessResponse, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<String> saveBusiness(@RequestBody BusinessRequest businessRequest){
        this.businessService.createNewBusiness(businessRequest);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{businessId}")
    public ResponseEntity<String> deleteBusiness(@PathVariable("businessId") int businessId){
        this.businessService.deleteBusiness(businessId);
        return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    }
}
