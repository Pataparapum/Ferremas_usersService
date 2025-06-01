package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.Models.userFuncionarioModel;
import com.ferremasGateway.ferremas_gateway.proyection.userClientProyection;
import com.ferremasGateway.ferremas_gateway.proyection.userFProyection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userFuncionaryRepository extends JpaRepository<userFuncionarioModel, Long> {

    @Query(value = "select u.userFid, u.nombres, u.apellidos, t.user_type_id, t.tipo_usuario " +
            "from user_funcionario_model u join type_user_model t " +
            "on (u.user_typeid = t.user_type_id) " +
            "where u.userFid = :id", nativeQuery = true)
    userFProyection findUserDtoById(@Param("id") Long id);

    @Query(value = "select u.userFid, u.nombres, u.apellidos, t.user_type_id, t.tipo_usuario " +
            "from user_funcionario_model u join type_user_model t " +
            "on (u.user_typeid = t.user_type_id) ", nativeQuery = true)
    List<userFProyection> findUsersDto();
}
