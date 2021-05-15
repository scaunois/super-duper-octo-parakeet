package io.scaunois.sdopbackend.rest.resource;

import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Builder
public class CardDto {
  private CardColor color;
  private CardValue value;
}
