package com.examly.springapp.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name = "admin", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId")
    private long adminId;
    @Email
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "adminName")
    private String adminName;
    @NotBlank
    @Column(name = "adminPassword")
    private String adminPassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "admin_roles",
            joinColumns = @JoinColumn(name = "adminId",referencedColumnName = "adminId"),
            inverseJoinColumns =@JoinColumn(name="roleId",referencedColumnName = "id"))
    private Collection<Role> Adminroles;

    public Admin(String email, String adminName, String adminPassword, Collection<Role> adminroles) {
        this.email = email;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        Adminroles = adminroles;
    }

    public Admin() {
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Collection<Role> getAdminroles() {
        return Adminroles;
    }

    public void setAdminroles(Collection<Role> adminroles) {
        Adminroles = adminroles;
    }
}
