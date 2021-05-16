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
  appTitle = 'super-duper-octo-parakeet';
  appSubtitle = 'Test technique Atexo - Afficher et trier une main de cartes à jouer';
}
