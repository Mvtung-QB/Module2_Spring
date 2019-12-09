package com.example.furama.model;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.exception.DataException;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Table(name = "tblhopdong")
public class HopDong {
    @Id
    @Column(name = "idhopdong")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idHopDong;

    @NotNull(message = "id khách hàng không thể trống")
    @Range(min = 1, max = 13,message = "Giá trị min 1 và max 13")
    @Column(name = "idkhachhang")
    private int idKhachHang;

    @NotNull(message = "Ngày làm hợp đồng không thể trống")
    @Column(name = "ngaylamhopdong")
    private Date ngayLamHopDong;

    @NotNull(message = "Ngày Kết thúc hợp đồng không thể trống")
    @Column(name = "ngayketthuc")
    private Date ngayketThuc;

    @Column(name = "tiendatcoc")
    private double tienDatCoc;

    @ManyToOne
    @JoinColumn(name = "iddichvu")
    private Services Id;

    public HopDong() {
    }

    public HopDong(int idKhachHang, Date ngayLamHopDong, Date ngayketThuc, double tienDatCoc, Services id) {
        this.idKhachHang = idKhachHang;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayketThuc = ngayketThuc;
        this.tienDatCoc = tienDatCoc;
        Id = id;
    }

    public int getIdHopDong() {
        return idHopDong;
    }

    public void setIdHopDong(int idHopDong) {
        this.idHopDong = idHopDong;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Date getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(Date ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public Date getNgayketThuc() {
        return ngayketThuc;
    }

    public void setNgayketThuc(Date ngayketThuc) {
        this.ngayketThuc = ngayketThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public Services getId() {
        return Id;
    }

    public void setId(Services id) {
        Id = id;
    }

    @Override
    public String toString() {
        return this.idHopDong+"_"+this.idKhachHang+"_"+this.ngayLamHopDong+"_"+this.ngayketThuc+"_"+this.tienDatCoc+"_"+this.Id.getId();
    }
}
