package com.ferremasGateway.ferremas_gateway.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class cardDataModel {


    /* Columna del modelo */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToOne
    @JoinColumn(name="userCId")
    private userClientModel userId;

    @Column(length = 16, nullable = false)
    private String numero;

    @Column(nullable = false)
    private Date fechaV;

    @Column(length = 3, nullable = false)
    private int CVV;

    @Column(length = 100, nullable = false)
    private String nombrePropietario;



    /* Getters and Setters */

    public Long getCardId() {return cardId;}

    public void setCardId(Long cardId) {cardId = cardId;}

    public userClientModel getUserId() {return userId;}

    public void setUserId(userClientModel userId) {this.userId = userId;}

    public String getNumero() {return numero;}

    public void setNumero(String numero) {this.numero = numero;}

    public Date getFechaV() {return fechaV;}

    public void setFechaV(Date fechaV) {this.fechaV = fechaV;}

    public int getCVV() {return CVV;}

    public void setCVV(int CVV) {this.CVV = CVV;}

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
}
