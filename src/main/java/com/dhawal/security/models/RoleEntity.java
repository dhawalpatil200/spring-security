package com.dhawal.security.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "roles")
@Data  // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor  // Generates a no-args constructor
@AllArgsConstructor // Generates a constructor with all fields
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private int id;

    private String name;

    public RoleEntity(String name) {
        this.name = name;
    }
}
