package io.scaunois.sdopbackend.domain.model;

import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Card {
  private CardColor color;
  private CardValue value;
}
