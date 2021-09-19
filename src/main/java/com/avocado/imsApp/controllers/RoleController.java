package com.avocado.imsApp.controllers;


import com.avocado.imsApp.dto.RoleRequest;
import com.avocado.imsApp.dto.RoleResponse;
import com.avocado.imsApp.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;


    @GetMapping
    public ResponseEntity<Set<RoleResponse>> getAllRoles(){
       return new ResponseEntity<>(this.roleService.getAllRoles(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createNewRole(@RequestBody RoleRequest roleRequest){
        this.roleService.createRole(roleRequest);
        return ResponseEntity.ok("Role Created Successfully");
    }
}
