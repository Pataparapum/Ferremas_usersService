package com.ferremasGateway.ferremas_gateway.service;

import com.ferremasGateway.ferremas_gateway.Models.listaPedidosModel;
import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import com.ferremasGateway.ferremas_gateway.Repositories.pedidosRepository;
import com.ferremasGateway.ferremas_gateway.Repositories.userRepository;
import com.ferremasGateway.ferremas_gateway.proyection.pedidosProyection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pedidosService {

    @Autowired
    private static final Logger log = LoggerFactory.getLogger(cardService.class);

    @Autowired
    private pedidosRepository pedidoR;

    @Autowired
    private userRepository userR;

    public ResponseEntity<List<pedidosProyection>> getPedidosFromClient(Long clientId) {
        List <pedidosProyection> pedido = pedidoR.findAllPedidoFromClient(clientId);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pedido);
    }

    public ResponseEntity<pedidosProyection> getPedidoFromClientById(Long clientId, Long pedidoId) {
        pedidosProyection pedido = pedidoR.findPedidoFromClientById(clientId, pedidoId);

        if (pedido == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pedido);
    }

    public void crearPedido(Long clientId, listaPedidosModel newPedido) {
        userClientModel user = userR.findById(clientId)
                .orElseThrow();

        newPedido.setUserId(user);

        pedidoR.save(newPedido);
    }

    public void deletePedido(Long pedidoId) {pedidoR.deleteById(pedidoId);}


}
