import { ApiService } from './util/api.service';
import { Card } from '../model/card.model';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class CardService {

    readonly ENDPOINT_RANDOM_HAND = 'random-cards-hand';
    
    constructor(private apiService: ApiService) { }

    getRandomHand(wishedHandSize?: number): Observable<Card[]> {
        
        const params = wishedHandSize ? { handSize: wishedHandSize } : null;

        return this.apiService.get(this.ENDPOINT_RANDOM_HAND, { params });
    }

}
