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
@Entity(name = "businesses")
@Audited
public class Business extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String businessName;

    private String businessShortName;

    @JoinColumn(name = "business_id")
    @OneToMany
    private List<User> users;
}
