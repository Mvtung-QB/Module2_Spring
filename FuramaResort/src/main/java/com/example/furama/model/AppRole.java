package com.example.furama.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tblapprole")
public class AppRole {
    @Id
    @Column(name = "roleid")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int roleId;

    @Column(name = "rolename")
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    @OneToMany(targetEntity = RoleUser.class)
    private List<RoleUser> roleUserList;

    public List<RoleUser> getRoleUserList() {
        return roleUserList;
    }

    public void setRoleUserList(List<RoleUser> roleUserList) {
        this.roleUserList = roleUserList;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AppRole() {
    }
}
