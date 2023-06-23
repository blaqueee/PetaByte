package com.spring.petabyte.entity;

import javax.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
