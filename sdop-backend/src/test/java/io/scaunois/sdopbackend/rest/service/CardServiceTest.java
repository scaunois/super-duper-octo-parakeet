package io.scaunois.sdopbackend.rest.service;

import io.scaunois.sdopbackend.rest.resource.CardDto;
import io.scaunois.sdopbackend.shared.constants.MiscConstants;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CardServiceTest {

  @Autowired
  CardService cardService;

  @DisplayName("Should return a hand of distinct, randomly choosen cards of size DEFAULT_HAND_SIZE when calling getRandomHand() method with an empty parameter")
  @Test
  void test_getRandomHand_withEmptyParameter() {
    // when
    List<CardDto> cardsHand = cardService.getRandomHand(null);

    // then
    assertThat(cardsHand).hasSize(MiscConstants.DEFAULT_HAND_SIZE);
    assertTrue(allCardsAreDifferent(cardsHand));
  }

  @DisplayName("Should return a hand of distinct, randomly choosen cards of size N when calling getRandomHand() method with handSize=N and N is positive and <= the cards deck size")
  @Test
  void test_getRandomHand_withExplicitAndValidHandSize() {
    // when
    // this test should work for any value between 1 and "the whole deck" so we pick a random value as a parameter to call the method
    int wishedHandSize = RandomUtils.nextInt(1, MiscConstants.CARDS_DECK_MAX_SIZE + 1);
    List<CardDto> cardsHand = cardService.getRandomHand(wishedHandSize);

    // then
    assertThat(cardsHand).hasSize(wishedHandSize);
    assertTrue(allCardsAreDifferent(cardsHand));
  }

  @DisplayName("Should throw an Exception when calling getRandomHand() method with a negative parameter")
  @Test
  void test_getRandomHand_withInvalidHandSize_Negative() {
    int invalidWishedHandSize = (-1) * RandomUtils.nextInt(); // random negative value
    assertThatThrownBy(() -> {
      List<CardDto> cardsHand = cardService.getRandomHand(invalidWishedHandSize);
    })
    .isInstanceOf(IllegalArgumentException.class)
    .hasMessage("Could not get random cards hand for size: " + invalidWishedHandSize);
  }

  @DisplayName("Should throw an Exception when calling getRandomHand() method with a parameter > cards deck size")
  @Test
  void test_getRandomHand_withInvalidHandSize_TooHigh() {
    int invalidWishedHandSize = MiscConstants.CARDS_DECK_MAX_SIZE + RandomUtils.nextInt(); // random value > cards deck size
    assertThatThrownBy(() -> {
      List<CardDto> cardsHand = cardService.getRandomHand(invalidWishedHandSize);
    })
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("Could not get random cards hand for size: " + invalidWishedHandSize);
  }

  /**
   * Utility method to check that all cards of a hand are distinct
   * (because when you are playing cards without cheating you should not be able to have the same card twice in your hand!)
   */
  private boolean allCardsAreDifferent(List<CardDto> cardsHand) {
    return cardsHand.size() != cardsHand.stream().distinct().count();
  }
}
