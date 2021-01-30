package com.example.cricket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JwtBlacklist")
public class JwtBlacklist {
    @Id
    @Column
    private int user_id;
    @Column
    private String token;

    public int get_Userid() {
        return user_id;
    }

    public void set_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JwtBlacklist{" +
                "_id='" + user_id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}