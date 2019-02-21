import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HEROES } from '../mock-heores';
import { HeroService } from '../hero.service';

@Component({
    selector: 'app-heroes',
    templateUrl: './HeroList.component.html',
    styleUrls: ['./HeroList.component.css']
})
export class HeroesComponent implements OnInit {
    heroes: Hero[];
    selectedHero: Hero;
    constructor(private heroService: HeroService) { }
    onSelect(hero: Hero): void {
        this.selectedHero = hero;
    }
    getHeroes(): void {
        this.heroService.getHeroes().subscribe(heroes => this.heroes = heroes);
    }
    ngOnInit() {
        this.getHeroes();
    }

}
