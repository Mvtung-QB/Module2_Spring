package quanlytinh.quanly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "hoten")
    private String name;
    @Column(name = "cmnd")
    private int cmnd;
    @Column(name = "diachi")
    private String diachi;
    @Column(name = "email")
    private String email;

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

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer() {

    }

    public Customer(int id, String name, int cmnd, String diachi, String email) {
        this.id = id;
        this.name = name;
        this.cmnd = cmnd;
        this.diachi = diachi;
        this.email = email;
    }
}
