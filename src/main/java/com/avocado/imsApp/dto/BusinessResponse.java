package com.avocado.imsApp.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessResponse {

    private String businessName;
    private String businessShortName;
    private String createdBy;
    private String updatedBy;
    private Long createdDate;
    private Long updatedDate;

    private List<UserResponse> users;
}
