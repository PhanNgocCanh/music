package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId")
    public long accountId;

    @Column(name = "FullName")
    public String fullName;

    @Column(name = "Password")
    public String password;

    @Column(name = "status")
    public int status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AccountRole", joinColumns = @JoinColumn(name = "Email"),
            inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<Role> roles = new ArrayList<>();
    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
