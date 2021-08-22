package com.avocado.imsApp.model.common;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
public class Whodunit {

    private Instant createDate;
    private Instant updatedDate;
    private String updatedBy;
    private String createdBy;
}
