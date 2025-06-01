package com.ferremasGateway.ferremas_gateway.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Optional;

@Entity
public class userClientModel {

    /* Columnas del modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCId;

    @Column(length = 100, nullable = false)
    private String nombres;
    @Column(length = 100, nullable = false)
    private String apellido;
    @Column(length = 100, nullable = false)
    private String contrasena;
    @Column(nullable = false)
    private Short edad;

    @ManyToOne
    @JoinColumn(name="userTypeid")
    private typeUserModel typeUser;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<cardDataModel> cards;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<listaPedidosModel> pedidos;


    /* Getters and Setters */

    public List<cardDataModel> getCards() {return cards;}

    public void setCards(List<cardDataModel> cards) {this.cards = cards;}

    public List<listaPedidosModel> getPedidos() {return pedidos;}

    public void setPedidos(List<listaPedidosModel> pedidos) {this.pedidos = pedidos;}

    public typeUserModel getTypeUser() {return typeUser;}

    public void setTypeUser(typeUserModel typeUser) {this.typeUser = typeUser;}

    public long getUserCId() {return userCId;}

    public void setUserCId(Long userCId) {userCId = userCId;}

    public String getNombres() {return nombres;}

    public void setNombres(String nombres) {this.nombres = nombres;}

    public String getApellido() {return apellido;}

    public void setApellido(String apellido) {this.apellido = apellido;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public Short getEdad() {return edad;}

    public void setEdad(Short edad) {this.edad = edad;}

}