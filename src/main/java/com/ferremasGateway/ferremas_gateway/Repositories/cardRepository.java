package com.ferremasGateway.ferremas_gateway.Repositories;

import com.ferremasGateway.ferremas_gateway.proyection.cardProyection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ferremasGateway.ferremas_gateway.Models.cardDataModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface cardRepository extends JpaRepository<cardDataModel, Long> {

    @Query(value = "select c.card_id, c.nombre_propietario, substring(c.numero from 5 for 4) as numero, c.fechav, u.usercid " +
            "from card_data_model c join user_client_model u " +
            "on (c.user_id = :id) ", nativeQuery = true)
    List<cardProyection> findCardsFromClientId(@Param("id") Long clientId);

    @Query(value = "select c.card_id, c.nombre_propietario, substring(c.numero from 5 for 4) as numero, c.fechav, u.usercid " +
            "from card_data_model c join user_client_model u " +
            "on (c.user_id = :clientId ) " +
            "where c.card_id = :cardId", nativeQuery = true)
    cardProyection findCardFromCLientIdByCardId(@Param("cardId") Long cardId, @Param("clientId") Long clientID);
}
