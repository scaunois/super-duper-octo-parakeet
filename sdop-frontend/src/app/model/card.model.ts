import { CardColor } from './card-color.model';
import { CardValue } from './card-value.model';

export interface Card {
    color: CardColor;
    value: CardValue;
}