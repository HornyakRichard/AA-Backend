package com.richard.AssecoTest.common.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private boolean active;
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private boolean deletedFlag;
    private String email;
    private String emailToken;
    private LocalDateTime lastLogin;
    private String name;
    private boolean nextLoginChangePwd;
    private String password;
    private boolean passwordExpired;
    private String phone;
    private long settlementId;
    private String tempPassword;
    private boolean tempPasswordExpired;
    private boolean updated;
    private LocalDateTime updatedAt;
    private String username;
    private String userType;
    private String settlementsBySettlementId;
    private String userByCreatedId;
    private String userByDeletedId;
    private String userByUpdatedId;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private RoleData role = new RoleData();
}
