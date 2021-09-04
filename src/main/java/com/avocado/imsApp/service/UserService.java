package com.avocado.imsApp.service;

import com.avocado.imsApp.dto.UserRequest;
import com.avocado.imsApp.dto.UserResponse;
import com.avocado.imsApp.exception.ImsAppException;
import com.avocado.imsApp.model.Business;
import com.avocado.imsApp.model.Role;
import com.avocado.imsApp.model.User;
import com.avocado.imsApp.repository.BusinessRepository;
import com.avocado.imsApp.repository.RoleRepository;
import com.avocado.imsApp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void saveUser(UserRequest userRequest){
        Business business = this.businessRepository.findById(userRequest.getBusinessId())
                .orElseThrow(() -> new ImsAppException("Business with Id:" + userRequest.getBusinessId() + "Not Found"));


        List<Role> roles = roleRepository.findAllByRoleNameIn(new ArrayList<String>(userRequest.getRoleDetails().values()));

        User user = mapToDto(userRequest,business, roles);
        this.userRepository.save(user);
    }

    private User mapToDto(UserRequest userRequest, Business business, List<Role> roles){
        return User.builder()
                .firstName(userRequest.getFirstName())
                .middleName(userRequest.getMiddleName())
                .lastName(userRequest.getMiddleName())
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .city(userRequest.getCity())
                .state(userRequest.getState())
                .country(userRequest.getCountry())
                .zipCode(userRequest.getZipCode())
                .roles(roles)
                .business(business).build();
    }
}
