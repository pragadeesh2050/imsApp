package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "incidents")
@Getter
@Setter
@Audited
public class Incident extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    @Column(length = 4000)
    private String description;
    private String incidentType;
    @Column(nullable = false)
    private Integer priority;
    @Column(nullable = false)
    private Integer severity;

    @ManyToOne(optional = false)
    @JoinColumn(name = "source_business_id", nullable = false)
    private Business sourceBusiness;


    @ManyToOne(optional = false)
    @JoinColumn(name = "source_business_process_owner_id", nullable = false)
    private User sourceBusinessProcessOwner;



    @ManyToMany
    @JoinTable(name = "incident_users",
            joinColumns = @JoinColumn(name = "INCIDENT_id"),
            inverseJoinColumns = @JoinColumn(name = "USER_id"))
    private List<User> contributors;


}
