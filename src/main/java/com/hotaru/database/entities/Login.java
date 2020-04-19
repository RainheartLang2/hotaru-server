package com.hotaru.database.entities;

import com.hotaru.core.database.Identifiable;

import javax.persistence.*;

@Table(name="login",
        indexes = {
            @Index(name = "login_name_index", unique=true, columnList = "login_name")
        })
@Entity(name="login")
public class Login implements Credential, Identifiable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="login_name")
    private String loginName;

    @Column(name="password")
    private String password;

    public Login() {
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getIdentityInfo() {
        return this.loginName;
    }

    @Override
    public String getAuthorizingInfo() {
        return this.password;
    }
}
