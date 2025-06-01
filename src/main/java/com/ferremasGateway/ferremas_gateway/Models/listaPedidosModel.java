package com.ferremasGateway.ferremas_gateway.Models;

import jakarta.persistence.*;

@Entity
public class listaPedidosModel {

    /* Columnas del modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private userClientModel userId;

    @Column
    private String product;

    @Column
    private int precio;

    @Column
    private String detalles;

    @Column
    private String img;

    @Column
    private Boolean estado;


    /* Getters and Setters */

    public Long getPedidoId() {return pedidoId;}

    public void setPedidoId(Long pedidoId) {this.pedidoId = pedidoId;}

    public userClientModel getUserId() {return userId;}

    public void setUserId(userClientModel userId) {this.userId = userId;}

    public String getProduct() {return product;}

    public void setProduct(String product) {this.product = product;}

    public int getPrecio() {return precio;}

    public void setPrecio(int precio) {this.precio = precio;}

    public String getDetalles() {return detalles;}

    public void setDetalles(String detalles) {this.detalles = detalles;}

    public String getImg() {return img;}

    public void setImg(String img) {this.img = img;}

    public Boolean getEstado() {return estado;}

    public void setEstado(Boolean estado) {this.estado = estado;}
}
