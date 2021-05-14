package io.scaunois.sdopbackend.shared.mapper;

import io.scaunois.sdopbackend.domain.model.Card;
import io.scaunois.sdopbackend.rest.resource.CardDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardMapper {

  public List<CardDto> toDtoList(List<Card> hand) {
    return hand.stream().map(this::toDto).collect(Collectors.toList());
  }

  private CardDto toDto(Card card) {
    return CardDto.builder()
      .color(card.getColor())
      .value(card.getValue())
      .build();
  }
}
