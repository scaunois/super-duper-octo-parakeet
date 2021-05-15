package io.scaunois.sdopbackend.domain.model;

import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Card {
  private CardColor color;
  private CardValue value;
}
