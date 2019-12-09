package com.example.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbldichvu")
public class Services {
    @Id
    @Column(name = "iddichvu")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<HopDong> getHopDongs() {
        return hopDongs;
    }

    public void setHopDongs(List<HopDong> hopDongs) {
        this.hopDongs = hopDongs;
    }

    public KieuThue getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }

    @Column(name = "image")
    private String image;

    @Column(name = "tendichvu")
    private String nameServises;

    @Column(name = "dientich")
    private float areaUse;

    @Column(name = "chiphithue")
    private int rentalCosts;

    @Column(name = "songuoitoida")
    private int maxUser;

    @ManyToOne
    @JoinColumn(name = "idloaidichvu")
    private TypeService idTypeServices;

    @Column(name = "sotang")
    private int soTang;

    @Column(name = "trangthai")
    private String trangThai;

    @OneToMany(targetEntity = HopDong.class)
    private List<HopDong> hopDongs;

    @ManyToOne
    @JoinColumn(name = "idkieuthue")
    private KieuThue kieuThue;

    public Services() {
    }

    public Services(int id, String nameServises, float areaUse, int rentalCosts, int maxUser, TypeService idTypeServices, int soTang, String trangThai, KieuThue kieuThue) {
        Id = id;
        this.nameServises = nameServises;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.maxUser = maxUser;
        this.idTypeServices = idTypeServices;
        this.soTang = soTang;
        this.trangThai = trangThai;
        this.kieuThue = kieuThue;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNameServises() {
        return nameServises;
    }

    public void setNameServises(String nameServises) {
        this.nameServises = nameServises;
    }

    public float getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(float areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxUser() {
        return maxUser;
    }

    public void setMaxUser(int maxUser) {
        this.maxUser = maxUser;
    }

    public TypeService getIdTypeServices() {
        return idTypeServices;
    }

    public void setIdTypeServices(TypeService idTypeServices) {
        this.idTypeServices = idTypeServices;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public KieuThue getIdKieuThue() {
        return kieuThue;
    }

    public void setIdKieuThue(KieuThue kieuThue) {
        this.kieuThue = kieuThue;
    }
}
