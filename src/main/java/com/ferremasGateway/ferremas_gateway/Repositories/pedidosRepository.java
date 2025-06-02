package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.Models.listaPedidosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface pedidosRepository extends JpaRepository<listaPedidosModel, Long> {

    @Query(value = "select * from lista_pedidos_model where user_id = :id", nativeQuery = true)
    List<listaPedidosModel> findAllPedidoFromClient(@Param("id") Long clientId);

    @Query(value = "select * from lista_pedidos_model where user_id = :clientId and pedido_id = :pedidoId", nativeQuery = true)
    listaPedidosModel findPedidoFromClientById(@Param("clientId") Long clientId, @Param("pedidoId") Long pedidoid);
}
