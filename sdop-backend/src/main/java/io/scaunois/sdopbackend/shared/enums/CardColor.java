package io.scaunois.sdopbackend.shared.enums;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Arrays.stream;

/**
 * Using an enum to define the color of a card should allow us to easily sort them. For instance, diamonds is  "smaller" than hearts with the enum.
 */
public enum CardColor {
  // values are defined in the alphabetical order of their French translations (Carreau, Coeur, Pique, Trèfle)
  DIAMONDS, HEARTS, SPADES, CLUBS;

  public static Optional<CardColor> fromInt(int intValue) {
    return stream(CardColor.values()).filter(color -> color.ordinal() == intValue).findFirst();
  }
}
