package com.avocado.imsApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {

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
            joinColumns = @JoinColumn(name = "USER_id"),
            inverseJoinColumns = @JoinColumn(name = "INCIDENT_id"))
    private List<Incident> incident;

    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_id"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_id"))
    private List<Role> roles;

    public void setIncident(List<Incident> incident) {
        this.incident = incident;
    }

    public List<Incident> getIncident() {
        return incident;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
