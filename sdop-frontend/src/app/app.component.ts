import { CardColor } from './model/card-color.model';
import { CardValue } from './model/card-value.model';
import { Card } from './model/card.model';
import { CardService } from './service/card.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  cardsHand: Array<Card> = [];
  wishedHandSize!: number;
  handContentText = 'vide';

  constructor(private cardService: CardService) { }
  
  getImage(card: Card): string {
    const color = card.color.toLowerCase();
    const value = CardValue.stringValue(card.value);
    return `assets/images/cards/${value}-${color}.png`;
  }

  getNewHand() {
    this.cardService.getRandomHand(this.wishedHandSize).subscribe((cardsHand: Card[]) => {
      this.cardsHand = cardsHand;
      this.handContentText = (cardsHand.length > 0) ? `${cardsHand.length} cartes` : 'vide';
    });
  }

  sortCurrentHand() {
    this.cardsHand.sort((card1: Card, card2: Card) => {
      const colorOrder = Object.keys(CardColor).indexOf(card1.color) - Object.keys(CardColor).indexOf(card2.color);
      if (colorOrder != 0) {
        return colorOrder;
      } else {
        return CardValue.ordinalValue(card1.value) - CardValue.ordinalValue(card2.value);
        return 1;
      }
    });
  }
}
