package com.ferremasGateway.ferremas_gateway.proyection;

import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public interface cardProyection {
    Long getCardId();
    Long getUserCId();
    String getNumero();
    Date getFechaV();
    String getNombrePropietario();

}
