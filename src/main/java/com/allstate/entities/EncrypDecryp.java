package com.allstate.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "credential_storage")
@Data
public class EncrypDecryp {
    private int id;
    private String agent_name;
    private String carrier;
    private String username_carrier;
    private String password_carrier;
    private int flag;

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

}
