
export enum CardValue {
    ACE = "ACE",
    TWO = "TWO",
    THREE = "THREE",
    FOUR = "FOUR",
    FIVE = "FIVE",
    SIX = "SIX",
    SEVEN = "SEVEN",
    EIGHT = "EIGHT",
    NINE = "NINE",
    TEN = "TEN",
    JACK = "JACK",
    QUEEN = "QUEEN",
    KING = "KING"
}

export namespace CardValue {

     export function ordinalValue(cardValue: CardValue): number {
        return Object.keys(CardValue).indexOf(cardValue);
    }

    /**
     * Returns the string name corresponding to the value of the card (for example 'ace', '2', '3', 'king',...)
     */
    export function stringValue(cardValue: CardValue): string {
        switch (cardValue) {
            case CardValue.ACE: return 'ace';
            case CardValue.TWO: return '2';
            case CardValue.THREE: return '3';
            case CardValue.FOUR: return '4';
            case CardValue.FIVE: return '5';
            case CardValue.SIX: return '6';
            case CardValue.SEVEN: return '7';
            case CardValue.EIGHT: return '8';
            case CardValue.NINE: return '9';
            case CardValue.TEN: return '10';
            case CardValue.JACK: return 'jack';
            case CardValue.QUEEN: return 'queen';
            case CardValue.KING: return 'king';
            default: return 'unknown';
        }
    }
}