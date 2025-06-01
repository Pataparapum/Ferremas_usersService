package com.ferremasGateway.ferremas_gateway.service;

import com.ferremasGateway.ferremas_gateway.Models.typeUserModel;
import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import com.ferremasGateway.ferremas_gateway.Repositories.typeUserRepository;
import com.ferremasGateway.ferremas_gateway.Repositories.userRepository;
import com.ferremasGateway.ferremas_gateway.proyection.userClientProyection;
import com.ferremasGateway.ferremas_gateway.Dto.userNewDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userCService {

    @Autowired
    private userRepository userC;

    @Autowired
    private typeUserRepository typeUserRepo;

    public ResponseEntity<List<userClientProyection>> getUser() {
        List<userClientProyection> user = userC.findUsersDto();

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<userClientProyection> getUserById(Long id) {
        userClientProyection user = userC.findUserDtoById(id);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    public void postUser(userClientModel newUser) {
        typeUserModel typeUser = typeUserRepo.findById(1L)
                .orElseThrow();
        newUser.setTypeUser(typeUser);
        userC.save(newUser);
    }

    public void deleteUser(Long id) {
        userC.deleteById(id);
    }

    public void updateUser(Long id, userNewDataDto newData) {
        userClientModel user = userC.findById(id)
                .orElseThrow();

        user.setApellido(newData.getApellido());
        user.setNombres(newData.getNombres());
        user.setContrasena(newData.getContrasena());

        userC.save(user);
    }

}
