import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'front alterando o texto do titulo';
  minhaVariavel = 'Angular 9';
  meuTexto;

  getMinhaVariavel(){
    return 'Um texto';
  }

  site = 'http://www.grandeporte.com.br';

  onClick(){
    alert ( 'Event Biding' );
  }

  onKeyup( inputText ){
    //let cor = "yellow" local variavel
    this.meuTexto = inputText //global variavel
    console.log( inputText );
  }
}

