package com.avocado.imsApp.model;


import com.avocado.imsApp.model.common.Whodunit;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "businesses")
public class Business extends Whodunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String businessName;

    private String businessShortName;

    @JoinColumn(name = "business_id")
    @OneToMany
    private List<User> users;
}
