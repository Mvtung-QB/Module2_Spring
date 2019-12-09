package com.example.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblappuser")
public class AppUser {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "pass")
    private String password;

    @OneToMany(targetEntity = RoleUser.class)
    private List<RoleUser> roleUserList;

    public List<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUser> roleUserList) {
        this.roleUserList = roleUserList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AppUser() {
    }
}
