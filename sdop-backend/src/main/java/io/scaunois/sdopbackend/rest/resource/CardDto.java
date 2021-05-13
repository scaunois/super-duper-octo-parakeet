package io.scaunois.sdopbackend.rest.resource;

import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
  private CardColor color;
  private CardValue value;
}
