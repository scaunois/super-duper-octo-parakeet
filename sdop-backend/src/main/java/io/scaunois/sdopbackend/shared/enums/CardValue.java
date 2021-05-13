package io.scaunois.sdopbackend.shared.enums;

/**
 * Using an enum to define the value of a card should allow us to easily sort them.
 * We could not simply use numbers, because there is also "figures" (Jack = Valet (FR), Queen = Reine (FR) and King = Roi (FR)).
 * Even the 1 as a special name in cards games (Ace = As (FR)).
 * In this enum, Ace is the smallest value, and the King the greatest one.
 */
public enum CardValue {
  ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}
