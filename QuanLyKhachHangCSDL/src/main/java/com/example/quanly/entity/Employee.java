package com.example.quanly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblnhanvien")
public class Employee {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "tuoi")
    private int tuoi;
    @Column(name = "ten")
    private String ten;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "lop")
    private String lop;

    public Employee(Long id, int tuoi, String ten, String diachi, String lop) {
        this.id = id;
        this.tuoi = tuoi;
        this.ten = ten;
        this.diachi = diachi;
        this.lop = lop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Employee() {
    }

}
