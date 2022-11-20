package com.savichev.customerdb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserInfo_generator")
    @SequenceGenerator(name="UserInfo_generator", sequenceName = "UserInfo_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "name",unique = false, nullable=false)
    private String name;
    @Column(name = "surname",unique = false, nullable=false)
    private String surname;
    @Column(name = "company",unique = false, nullable=false)
    private String company;
    @Column(name = "email",unique = false, nullable=false)
    private String email;

    @OneToMany(targetEntity = Configuration.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "User_ID")
    @JsonManagedReference
    private List<Configuration> configurations;

    public List<Configuration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @OneToMany(targetEntity = Configuration.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JsonManagedReference
//    List<Configuration> configurations;


}
