package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Role extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;

    @JoinColumn(name = "role_id")
    @OneToMany
    private List<User> users;
}
