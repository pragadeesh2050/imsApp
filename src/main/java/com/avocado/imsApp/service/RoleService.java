package com.avocado.imsApp.service;

import com.avocado.imsApp.dto.RoleRequest;
import com.avocado.imsApp.dto.RoleResponse;
import com.avocado.imsApp.model.Role;
import com.avocado.imsApp.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Set<RoleResponse> getAllRoles(){
        return  this.roleRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toSet());
    }

    @Transactional
    public void createRole(RoleRequest roleRequest){
        Role role = mapDtoToRole(roleRequest);
        this.roleRepository.save(role);
    }

    private Role mapDtoToRole(RoleRequest roleRequest) {
        return Role.builder().roleName(roleRequest.getRoleName()).build();
    }

    private RoleResponse mapToDto(Role role) {
       return RoleResponse.builder().id(role.getId()).roleName(role.getRoleName()).build();
    }

}
