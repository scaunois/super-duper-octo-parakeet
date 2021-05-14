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

  constructor(private cardService: CardService) { }
  
  getNewHand() {
    this.cardService.getRandomHand(this.wishedHandSize).subscribe((cardsHand: Card[]) => {
      this.cardsHand = cardsHand;
    });
  }

  getImage(card: Card): string {
    const color = card.color.toLowerCase();
    const value = CardValue.stringValue(card.value);
    return `assets/images/cards/${value}-${color}.png`;
  }
}
