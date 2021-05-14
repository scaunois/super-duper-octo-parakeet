package io.scaunois.sdopbackend.shared.util;

import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;

public class CardUtils {

  /**
   * Gives the size of a card deck in OUR representation. It is only dependant of allowed colors and values defined in enums CardColor and CardValue
   * For example if there is 4 colors (Diamonds, Hearts, Spades, Clubs) and 13 values (from 1 to 10 + Jack, Queen and King) we have a deck of 52 cards
   * This method would have to change if we decided to take into account jokers, for instance, or trump cards of French "tarot"...
   */
  public static int getDeckMaxSize() {
    return CardColor.values().length * CardValue.values().length;
  }

  /** avoid the class to be instanciated */
  private CardUtils() {}
}
