package com.example.furama.model;

import javax.persistence.*;

@Entity
public class RoleUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private AppRole appRole;

    @ManyToOne
    @JoinColumn(name = "userid")
    private AppUser appUser;

    public RoleUser(AppRole appRole, AppUser appUser) {
        this.appRole = appRole;
        this.appUser = appUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
