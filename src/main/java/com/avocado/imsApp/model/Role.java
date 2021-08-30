package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
@Audited
public class Role extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;

    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany
    private List<User> users;
}
