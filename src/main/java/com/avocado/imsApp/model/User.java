package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Audited
@Builder
public class User extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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

    @JoinColumn(name = "business_id", nullable = false, columnDefinition = "Integer")
    @ManyToOne(optional = false)
    private Business business;

    @ManyToMany
    @JoinTable(name = "incident_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "incident_id"))
    private List<Incident> incidents;

    @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
