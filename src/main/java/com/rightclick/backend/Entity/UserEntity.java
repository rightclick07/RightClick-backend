package com.rightclick.backend.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "user_details")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    String password;

    @Column(name = "user_roles_id", nullable = false)
    Integer userRolesId;

    @Column(name = "mobile_number", nullable = false)
    BigInteger mobileNumber;

    public UserEntity() {
    }

    public UserEntity(Integer userId, String firstName, String middleName, String lastName, String userName, String emailId, String password, Integer userRolesId, BigInteger mobileNumber) {
        this.userId = userId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        this.userRolesId = userRolesId;
        this.mobileNumber = mobileNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserRolesId() {
        return userRolesId;
    }

    public void setUserRolesId(Integer userRolesId) {
        this.userRolesId = userRolesId;
    }

    public BigInteger getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", password='" + password + '\'' +
                ", userRolesId=" + userRolesId +
                ", mobileNumber=" + mobileNumber +
                '}';
    }
}
