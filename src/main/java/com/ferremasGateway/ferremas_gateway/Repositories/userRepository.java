package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.proyection.userClientProyection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepository extends JpaRepository<userClientModel, Long> {

    @Query(value = "select a.userCId, a.apellido, a.nombres, a.edad, b.user_type_id, b.tipo_usuario " +
            "from user_client_model as a inner join type_user_model as b " +
            "on (a.user_typeid = b.user_type_id ) " +
            "where u.userCid = :id", nativeQuery = true)
    userClientProyection findUserDtoById(@Param("id") Long id);

    @Query(value = "select a.userCId, a.apellido, a.nombres, a.edad, b.user_type_id, b.tipo_usuario " +
            "from user_client_model as a inner join type_user_model as b " +
            "on (a.user_typeid = b.user_type_id );", nativeQuery = true)
    List<userClientProyection> findUsersDto();
}
