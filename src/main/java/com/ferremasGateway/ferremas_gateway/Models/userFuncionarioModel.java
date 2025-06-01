package com.ferremasGateway.ferremas_gateway.Models;

import jakarta.persistence.*;

@Entity
public class userFuncionarioModel {

    /* Columnas del modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userFId;

    @Column(length = 100, nullable = false)
    private String nombres;

    @Column(length = 100, nullable = false)
    private String apellidos;

    @Column(length = 100, nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name="userTypeid")
    private typeUserModel typeUser;

    /* Getters and Setters */

    public Long getUserFId() {
        return userFId;
    }

    public void setUserFId(Long userFId) {
        this.userFId = userFId;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public typeUserModel getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(typeUserModel typeUser) { this.typeUser = typeUser; }
}
