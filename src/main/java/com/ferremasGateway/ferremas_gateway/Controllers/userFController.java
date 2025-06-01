package com.ferremasGateway.ferremas_gateway.Controllers;

import com.ferremasGateway.ferremas_gateway.Models.userFuncionarioModel;
import com.ferremasGateway.ferremas_gateway.proyection.userFNewDataDto;
import com.ferremasGateway.ferremas_gateway.proyection.userFProyection;
import com.ferremasGateway.ferremas_gateway.service.userFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class userFController {

    @Autowired
    private userFService service;

    @GetMapping
    public ResponseEntity<List<userFProyection>> getUser() {
        return service.getUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<userFProyection> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/post/{cargo}")
    public void postUser(@PathVariable String cargo, @RequestBody userFuncionarioModel newUser) { service.postUser(cargo, newUser); }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody userFNewDataDto newData) { service.updateUser(id, newData); }
}
