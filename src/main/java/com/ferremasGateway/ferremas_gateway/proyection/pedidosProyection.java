package com.ferremasGateway.ferremas_gateway.proyection;

import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public interface pedidosProyection {
    Long getPedidoId();
    userClientModel getUserId();
    String getProduct();
    int getPrecio();
    String getDetalles();
    String getimg();
    Boolean getEstado();
}
