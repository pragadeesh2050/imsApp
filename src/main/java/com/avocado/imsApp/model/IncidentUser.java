package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "incident_users")
@Getter
@Setter
@Audited
public class IncidentUser extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User contributor;

    @ManyToOne
    @JoinColumn(name = "incident_id")
    private Incident incident;
}
