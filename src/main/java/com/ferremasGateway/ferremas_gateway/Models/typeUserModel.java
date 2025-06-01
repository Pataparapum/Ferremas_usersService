package com.ferremasGateway.ferremas_gateway.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class typeUserModel {

    /* Columnas del modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTypeId;

    @Column(length = 100, nullable = false, unique = true)
    private String tipo_usuario;

    @OneToMany(mappedBy = "typeUser", cascade = CascadeType.ALL)
    private List<userClientModel> client;

     @OneToMany(mappedBy = "typeUser", cascade = CascadeType.ALL)
    private List<userFuncionarioModel> funcionario;


     /* Getters and Setters*/

    public List<userFuncionarioModel> getFuncionario() {return funcionario;}

    private void setFuncionario(List<userFuncionarioModel> funcionario) {this.funcionario = funcionario;}

    public List<userClientModel> getClient() {return client;}

    private void setClient(List<userClientModel> client) {this.client = client;}

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    private void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    private void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }
}
