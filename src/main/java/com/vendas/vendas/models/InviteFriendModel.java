package com.vendas.vendas.models;

import jakarta.persistence.*;

@Entity
@Table(name = "convidar")
public class InviteFriendModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String telefone;
    private String email;

    public InviteFriendModel(int id, String name, String telefone, String email) {
        this.id = id;
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InviteFriendModel() {
    }

}
