package com.avocado.imsApp.repository;

import com.avocado.imsApp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAllByRoleNameIn(List<String> roleNames);
}
