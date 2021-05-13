package io.scaunois.sdopbackend.rest.controller;

import io.scaunois.sdopbackend.rest.resource.CardDto;
import io.scaunois.sdopbackend.rest.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {

  private final CardService cardService;

  @Autowired
  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping("random-cards-hand")
  public List<CardDto> getRandomHand(@RequestParam(required = false) Integer handSize) {
    return cardService.getRandomHand(handSize);
  }

}
