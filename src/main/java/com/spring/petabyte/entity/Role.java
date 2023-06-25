package com.spring.petabyte.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Permission> permissions;

}
