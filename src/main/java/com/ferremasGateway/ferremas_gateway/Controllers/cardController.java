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

    @GetMapping("/client")
    public ResponseEntity<cardProyection> getCardFromClientById(@RequestParam Long clientId, @RequestParam Long cardId) {
        return service.getCardFromCLientIdById(clientId, cardId);
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
