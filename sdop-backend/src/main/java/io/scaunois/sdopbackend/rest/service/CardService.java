package io.scaunois.sdopbackend.rest.service;

import io.scaunois.sdopbackend.rest.resource.CardDto;
import io.scaunois.sdopbackend.shared.constants.MiscConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CardService {

  public List<CardDto> getRandomHand(Integer handSize) {
    if (handSize == null) {
      handSize = MiscConstants.DEFAULT_HAND_SIZE;
    }

    throw new UnsupportedOperationException("Method to be implemented");

    // TODO implement
  }

}
