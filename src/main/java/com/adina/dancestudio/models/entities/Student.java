package com.adina.dancestudio.models.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity(name="students")
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="student_id")
    private Long studentId;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="age")
    private Integer age;

    @NotNull
    @Column(name="phone_number")
    private Integer phoneNumber;

    @NotNull
    @Column(name="gender")
    private String gender;

    @NotNull
    @Column(name="account_password")
    private String accountPassword;

    @OneToOne(mappedBy = "student")
    private Subscription subscription;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;

    public Student(Long studentId, String firstName, String lastName, Integer age, Integer phoneNumber, String gender, String accountPassword) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.accountPassword = accountPassword;
    }

    public Student(){

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentsId) {
        this.studentId = studentsId;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    //@OneToOne(mappedBy = "student")
    //private Badge badge;
}