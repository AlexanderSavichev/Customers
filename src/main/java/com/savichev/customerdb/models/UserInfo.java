package com.savichev.customerdb.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;
    public String surname;
    public String company;
    public String email;
    @OneToMany(targetEntity = Configuration.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "customerId", referencedColumnName = "id")
    @JsonManagedReference
    public List <Configuration> configurations;


}
