package com.example.bigjavahomework.entityes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Countries {
    @Id
    private String code;

    @Column
    private String name;
    @Column
    private Boolean location;
    @Column
    private Boolean allowed;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLocation() {
        return location;
    }
    public void setLocation(Boolean location) {
        this.location = location;
    }

    public Boolean getAllowed() {
        return allowed;
    }
    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }
}
