import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-primeiro',
  templateUrl: './primeiro.component.html',
  styleUrls: ['./primeiro.component.scss']
})
export class PrimeiroComponent implements OnInit {

  constructor( private router : Router ) { }

  ngOnInit(): void {
  }

  goHome(){
    this.router.navigate([ '/home' ])
  }
}
