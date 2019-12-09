package com.example.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblkieuthue")
public class KieuThue {
    @Id
    @Column(name = "idkieuthue")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idKieuThue;

    @Column(name = "tenkieuthue")
    private String tenKieuThue;

    @OneToMany(targetEntity = Services.class)
    private List<Services> servicesList;

    public List<Services> getServicesList() {
        return servicesList;
    }

    public void setServicesList(List<Services> servicesList) {
        this.servicesList = servicesList;
    }

    public KieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }

    public KieuThue() {
    }

    public int getIdKieuThue() {
        return idKieuThue;
    }

    public void setIdKieuThue(int idKieuThue) {
        this.idKieuThue = idKieuThue;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }
}
