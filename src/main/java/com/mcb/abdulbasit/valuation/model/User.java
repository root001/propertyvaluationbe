package com.mcb.abdulbasit.valuation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String name;
    private String businessUnit;
    private String contactNumber;
    private String password;
}
