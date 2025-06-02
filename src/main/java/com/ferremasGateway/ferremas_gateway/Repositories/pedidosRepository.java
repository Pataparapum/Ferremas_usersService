package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.Models.listaPedidosModel;
import com.ferremasGateway.ferremas_gateway.proyection.pedidosProyection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface pedidosRepository extends JpaRepository<listaPedidosModel, Long> {

    @Query(value = "select l.pedido_id, l.detalles, l.estado, l.img, l.precio, l.product, u.usercid " +
            "from lista_pedidos_model l join user_client_model u " +
            "on(l.user_id = :id);", nativeQuery = true)
    List<pedidosProyection> findAllPedidoFromClient(@Param("id") Long clientId);

    @Query(value = "select l.pedido_id, l.detalles, l.estado, l.img, l.precio, l.product, u.usercid " +
            "from lista_pedidos_model l join user_client_model u " +
            " on(l.user_id = u.usercid) " +
            "where user_id = :clientId and pedido_id = :pedidoId", nativeQuery = true)
    pedidosProyection findPedidoFromClientById(@Param("clientId") Long clientId, @Param("pedidoId") Long pedidoid);
}
