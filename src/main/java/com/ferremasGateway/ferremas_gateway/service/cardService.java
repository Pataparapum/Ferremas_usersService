package com.ferremasGateway.ferremas_gateway.service;

import com.ferremasGateway.ferremas_gateway.Models.cardDataModel;
import com.ferremasGateway.ferremas_gateway.Models.userClientModel;
import com.ferremasGateway.ferremas_gateway.Repositories.cardRepository;
import com.ferremasGateway.ferremas_gateway.Repositories.userRepository;
import com.ferremasGateway.ferremas_gateway.proyection.cardProyection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class cardService {

    private static final Logger log = LoggerFactory.getLogger(cardService.class);
    @Autowired
    private cardRepository cardR;

    @Autowired
    private userRepository userR;

    public ResponseEntity<List<cardProyection>> getCardsFromClientId(Long clientId) {
        List<cardProyection> card = cardR.findCardsFromClientId(clientId);

        if (card == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(card);
    }

    public ResponseEntity<cardProyection> getCardFromCLientIdById(Long clientId, Long cardId){
        cardProyection card = cardR.findCardFromCLientIdByCardId(cardId, clientId);

        if (card == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(card);
    }

    public void postCard(cardDataModel newCard, Long userId) {
        userClientModel user = userR.findById(userId)
                .orElseThrow();

        newCard.setUserId(user);
        log.info("data: "+ user);

        cardR.save(newCard);
    }

    public void deleteCard(Long cardId) {
        cardR.deleteById(cardId);
    }
}
