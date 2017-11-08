package com.gladunalexander.test_task.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander Gladun on 07/11/2017.
 */

@Entity
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private int id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<User> users = new ArrayList<>();


    public Company() {}

    public Company(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
