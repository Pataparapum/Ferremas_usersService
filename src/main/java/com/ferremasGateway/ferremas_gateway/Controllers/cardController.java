package com.ferremasGateway.ferremas_gateway.Controllers;

import com.ferremasGateway.ferremas_gateway.Models.cardDataModel;
import com.ferremasGateway.ferremas_gateway.proyection.cardProyection;
import com.ferremasGateway.ferremas_gateway.service.cardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class cardController {

    @Autowired
    private cardService service;

    @GetMapping("/{clientId}")
    public ResponseEntity<List<cardProyection>> getCardsFromClient(@PathVariable Long clientId) { return service.getCardsFromClientId(clientId); }

    @GetMapping("/one/{clientId}")
    public ResponseEntity<cardProyection> getCardFromClientById(@PathVariable Long clientId, @RequestParam String cardId) {
        Long idCard = Long.parseLong(cardId);
        return service.getCardFromCLientIdById(clientId, idCard);
    }

    @PostMapping("/post/{userId}")
    public void addCard(@PathVariable Long userId, @RequestBody cardDataModel newCard) {
        service.postCard(newCard, userId);
    }

    @DeleteMapping("/delete/{cardId}")
    public void deleteCard(@PathVariable Long cardId) {
        service.deleteCard(cardId);
    }
}
