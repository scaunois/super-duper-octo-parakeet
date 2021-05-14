package io.scaunois.sdopbackend.shared.constants;

import io.scaunois.sdopbackend.shared.util.CardUtils;

/**
 * For now we don't have much constants, but if theirs number increases, put them in different classes.
 */
public class MiscConstants {
  public static final int CARDS_DECK_MAX_SIZE = CardUtils.getDeckMaxSize(); // Deck size is determined at one place, once and for all
  public static final int DEFAULT_HAND_SIZE = 10;

  /** avoid the class to be instanciated */
  private MiscConstants() {}
}
