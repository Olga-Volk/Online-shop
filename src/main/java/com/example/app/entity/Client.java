package com.example.app.entity;

import com.example.app.enums.ClientOrAdmin;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column (name = "hash_code")
    private int hashCode;

    @Enumerated (EnumType.ORDINAL)// сменить на стринг
    @Column (name = "access_level")
    private ClientOrAdmin accessLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public ClientOrAdmin getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(ClientOrAdmin accessLevel) {
        this.accessLevel = accessLevel;
    }
}
