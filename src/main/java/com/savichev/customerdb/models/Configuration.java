package com.savichev.customerdb.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Configuration {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "configuration_generator")
    @SequenceGenerator(name="configuration_generator", sequenceName = "configuration_seq", allocationSize=50)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    @NotNull(message = "Title has to be non Null")
    private String title;
    @NotNull(message = "CPU has to be non Null")
    private String cpu;
    @NotNull(message = "GPU has to be non Null")
    private String gpu;
    @NotNull(message = "RAM has to be non Null")
    private String ram;
    @NotNull(message = "Storage has to be non Null")
    private String storage;
    @NotNull(message = "Motherboard has to be non Null")
    private String motherboard;
    @NotNull(message = "Cooler has to be non Null")
    private String cooler;
    @NotNull(message = "Box has to be non Null")
    private String box;


    @JsonBackReference
    @ManyToOne(cascade = {CascadeType.ALL, CascadeType.MERGE})
    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }
}
