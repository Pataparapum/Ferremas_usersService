package com.ferremasGateway.ferremas_gateway.Controllers;

import com.ferremasGateway.ferremas_gateway.Models.listaPedidosModel;
import com.ferremasGateway.ferremas_gateway.proyection.pedidosProyection;
import com.ferremasGateway.ferremas_gateway.service.pedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class pedidosController {

    @Autowired
    pedidosService pedidosS;

    @GetMapping("/{clientId}")
    public ResponseEntity<List<pedidosProyection>> getPedidosFromClient(@PathVariable Long clientId) {
        return pedidosS.getPedidosFromClient(clientId);
    }

    @GetMapping("/one/{clientId}")
    public ResponseEntity<pedidosProyection> getPedidoFromClientById(@PathVariable Long clientId, @RequestParam String pedidoId) {
        Long id = Long.parseLong(pedidoId);
        return pedidosS.getPedidoFromClientById(clientId, id);
    }

    @PostMapping("/{clientId}")
    public void createPedido(@PathVariable Long clientId, @RequestBody listaPedidosModel pedido) {
        pedidosS.crearPedido(clientId, pedido);
    }

    @DeleteMapping("{id}")
    public void deletePedido(@PathVariable Long id) {
        pedidosS.deletePedido(id);
    }
}
