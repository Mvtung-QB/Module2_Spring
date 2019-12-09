package com.example.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblloaidichvu")
public class TypeService {

    @Id
    @Column(name = "idloaidichvu")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idTypeService;

    @OneToMany(targetEntity = Services.class)
    private List<Services> services;

    @Column(name = "tenloaidichvu")
    private String nameTypeService;

    public int getIdTypeService() {
        return idTypeService;
    }

    public void setIdTypeService(int idTypeService) {
        this.idTypeService = idTypeService;
    }

    public String getNameTypeService() {
        return nameTypeService;
    }

    public void setNameTypeService(String nameTypeService) {
        this.nameTypeService = nameTypeService;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public TypeService() {
    }

    public TypeService(int idTypeService, String nameTypeService) {
        this.idTypeService = idTypeService;
        this.nameTypeService = nameTypeService;
    }
}
