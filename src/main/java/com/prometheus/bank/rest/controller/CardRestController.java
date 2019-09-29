package com.prometheus.bank.rest.controller;

import com.prometheus.bank.entity.Card;
import com.prometheus.bank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardRestController {

    @Autowired
    CardService cardService;

    @GetMapping("/getCards")
    public List<Card> getAllCards() {

        List<Card> cards = cardService.getAllCards();
        return cards;
    }

    @GetMapping("/getCard/{id}")
    public String getCard() {
        return "";
    }

    @DeleteMapping("/deleteCard/{id}")
    public void deleteCard(@PathVariable String cardId) {

    }

    @PostMapping("/addCard")
    public void addCard() {

    }

    @PutMapping("/updateCard/{id}")
    public void updateCard(@PathVariable String cardId) {

    }

}
