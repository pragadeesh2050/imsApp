package com.avocado.imsApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String username;
    private String password;
    private String city;
    private String state;
    private String country;
    private long zipCode;
    private Integer businessId;
    private String businessName;
    private Set<Integer> roles;
}
