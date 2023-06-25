package com.spring.petabyte.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "permissions")
public class Permission extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;
}
