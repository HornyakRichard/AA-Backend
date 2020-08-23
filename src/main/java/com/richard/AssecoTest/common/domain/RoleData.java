package com.richard.AssecoTest.common.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.richard.AssecoTest.common.enums.Role;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
public class RoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne()
    @JsonBackReference
    private UserData user;

    private Role role = Role.PUBLIC;
}
