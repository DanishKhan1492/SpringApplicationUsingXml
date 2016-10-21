package com.springapplicationusingxml.entities;

import com.springapplicationusingxml.validators.Phone;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.GroupSequence;

/**
 * Created by muhamamddanish on 9/30/16.
 */

interface UserCheck{}
interface UserPhoneCheck{}
@Entity
@Table(name = "user")
@GroupSequence({UserCheck.class,User.class,UserPhoneCheck.class})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="FirstName")
    @NotEmpty(message = "NotEmpty.user.firstName ",groups = UserCheck.class)
    private String firstName;

    @Column(name="LastName")
    @NotEmpty(message = "NotEmpty.user.lastName",groups = UserCheck.class)
    private String lastName;

    @Column(name="Address")
    @NotEmpty(message = "NotEmpty.user.address",groups = UserCheck.class)
    private String address;

    @Column(name="PhoneNumber")
    @NotEmpty(message = "NotEmpty.user.phoneNumber", groups = UserCheck.class)
    @Phone(message = "Phone.user.phoneNumber",groups = UserCheck.class)
    private String phoneNumber;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
