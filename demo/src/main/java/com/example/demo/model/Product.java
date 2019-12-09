package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "masp")
    private Long masp;
    @Column(name = "nameproduct")
    private String nameproduct;
    @Column(name = "gia")
    private double gia;

    @Column(name = "image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getMasp() {
        return masp;
    }

    public void setMasp(Long masp) {
        this.masp = masp;
    }

    public String getNameProduct() {
        return nameproduct;
    }

    public void setNameProduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Product() {
    }

    public Product(Long masp, String nameproduct, double gia, String image) {
        this.masp = masp;
        this.nameproduct = nameproduct;
        this.gia = gia;
        this.image = image;
    }
}
