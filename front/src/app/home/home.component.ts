import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../produtos/produto.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(){

  }

  ngOnInit(){
    
    }

  title = 'front alterando o texto de verdade';
  minhaVariavel = 'Angular 9';
  meuTexto;
  hoje = new Date;
  obj = {nome: "Paulo"};

  site = 'http://grandeporte.com.br';

  getMinhaVariavel(){
    return 'Um texto';
  }

  onClick(){
    alert ('Event Binding');
  }

  onKeyup( inputText ){
    //let cor = 'yellow';
    this.meuTexto = inputText;
    console.log ( inputText );
  }

}
