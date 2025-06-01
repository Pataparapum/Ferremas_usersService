package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.Models.listaPedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface pedidosRepository extends JpaRepository<listaPedidosModel, Long> { }
