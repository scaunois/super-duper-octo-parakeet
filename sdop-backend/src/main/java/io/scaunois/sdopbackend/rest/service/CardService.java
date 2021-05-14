package io.scaunois.sdopbackend.rest.service;

import io.scaunois.sdopbackend.domain.model.Card;
import io.scaunois.sdopbackend.rest.resource.CardDto;
import io.scaunois.sdopbackend.shared.constants.MiscConstants;
import io.scaunois.sdopbackend.shared.enums.CardColor;
import io.scaunois.sdopbackend.shared.enums.CardValue;
import io.scaunois.sdopbackend.shared.mapper.CardMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CardService {

  private static final List<Card> FULL_CARD_DECK = initializeCardDeck52Cards();

  private final CardMapper cardMapper;

  @Autowired
  public CardService(CardMapper cardMapper) {
    this.cardMapper = cardMapper;
  }

  public List<CardDto> getRandomHand(Integer wishedSize) {
    if (wishedSize == null) {
      wishedSize = MiscConstants.DEFAULT_HAND_SIZE;
    }

    if (wishedSize < 0 || wishedSize > MiscConstants.CARDS_DECK_MAX_SIZE) {
      throw new IllegalArgumentException("Could not get cards hand of size: " + wishedSize);
    }

    List<Card> cardDeck = new ArrayList<>(FULL_CARD_DECK);
    List<Card> hand = new ArrayList<>();

    for (int i = 0; i < wishedSize; i++) {
      hand.add(pickRandomCardAndRemoveItFromDeck(cardDeck));
    }

    return cardMapper.toDtoList(hand);
  }

  private Card pickRandomCardAndRemoveItFromDeck(List<Card> cardDeck) {
    CardColor randomColor = CardColor.fromInt(RandomUtils.nextInt(0, CardColor.values().length)).orElseThrow();
    CardValue randomValue  = CardValue.fromInt(RandomUtils.nextInt(0, CardValue.values().length)).orElseThrow();
    Card card = new Card(randomColor, randomValue);

    // remove the card of the deck (it should not be picked twice)
    removeCardOfDeck(card, cardDeck);

    return card;
  }

  private void removeCardOfDeck(Card card, List<Card> cardDeck) {
    cardDeck.removeIf(card1 -> card1.equals(card));
  }

  private static List<Card> initializeCardDeck52Cards() {
    List<Card> deck = new ArrayList<>();
    for (CardColor color: CardColor.values()) {
      for (CardValue value: CardValue.values()) {
        deck.add(new Card(color, value));
      }
    }

    assert deck.size() == MiscConstants.CARDS_DECK_MAX_SIZE;
    return deck;

    // the above code could be replaced by the following stream loop, but a nested "for" loop is more intuitive
    /*
    return stream(CardColor.values())
      .flatMap(color -> stream(CardValue.values())
        .map(value -> new Card(color, value))
      ).collect(Collectors.toList());*/
  }

}
