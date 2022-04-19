package com.rightclick.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "user_details")
public class UserEntity {
    @Id
    @Column(name = "user_id", nullable = false)
    Integer userId;

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "middle_name", nullable = false)
    String middleName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "user_name", nullable = false)
    String userName;

    @Column(name = "email_id", nullable = false)
    String emailId;

    @Column(name = "user_password", nullable = false)
    String userPassword;

    @Column(name = "user_roles_id", nullable = false)
    Integer userRolesId;

    @Column(name = "mobile_number", nullable = false)
    BigInteger mobileNumber;


}
