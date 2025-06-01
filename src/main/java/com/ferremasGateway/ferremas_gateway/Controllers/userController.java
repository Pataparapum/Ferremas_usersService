package com.ferremasGateway.ferremas_gateway.Controllers;

import com.ferremasGateway.ferremas_gateway.proyection.userClientProyection;
import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import com.ferremasGateway.ferremas_gateway.Dto.userNewDataDto;
import com.ferremasGateway.ferremas_gateway.service.userCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userCService service;

    @GetMapping
    public ResponseEntity<List<userClientProyection>> getUser() {
        return service.getUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<userClientProyection> getUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/post")
    public void postUser(@RequestBody userClientModel newUser) {
        service.postUser(newUser);
    }

    @DeleteMapping("/del/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody userNewDataDto newData) {
       service.updateUser(id, newData);
    }
}
