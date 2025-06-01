package com.ferremasGateway.ferremas_gateway.service;

import com.ferremasGateway.ferremas_gateway.Models.typeUserModel;
import com.ferremasGateway.ferremas_gateway.Models.userFuncionarioModel;
import com.ferremasGateway.ferremas_gateway.Repositories.typeUserRepository;
import com.ferremasGateway.ferremas_gateway.Repositories.userFuncionaryRepository;
import com.ferremasGateway.ferremas_gateway.proyection.userFNewDataDto;
import com.ferremasGateway.ferremas_gateway.proyection.userFProyection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class userFService {

    Map<String, Long> tipoCargo = new HashMap<String, Long>();

    @Autowired
    private userFuncionaryRepository userF;

    @Autowired
    private typeUserRepository typeUserRepo;

    userFService() {
        tipoCargo.put("vendedor", 2L);
        tipoCargo.put("bodeguero", 3L);
        tipoCargo.put("contador",4L);

    }

    public ResponseEntity<List<userFProyection>> getUser() {
        List<userFProyection> user = userF.findUsersDto();

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    public ResponseEntity<userFProyection> getUserById(Long id) {
        userFProyection user = userF.findUserDtoById(id);

        if(user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    public void postUser(String cargo, userFuncionarioModel newUser) {

        typeUserModel typeUser = typeUserRepo.findById(tipoCargo.get(cargo))
                .orElseThrow();

        newUser.setTypeUser(typeUser);

        userF.save(newUser);
    }

    public void deleteUser(Long id) {
        userF.deleteById(id);
    }

    public void updateUser(Long id, userFNewDataDto newData) {
        userFuncionarioModel user = userF.findById(id)
                .orElseThrow();

        user.setApellidos(newData.getApellidos());
        user.setNombres(newData.getNombres());
        user.setContrasena(newData.getContrasena());

        userF.save(user);
    }
}
