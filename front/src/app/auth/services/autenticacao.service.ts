import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from 'src/app/shared/models/cliente';

import { environment } from 'src/environments/environment';

import { map } from 'rxjs/operators';
import { BehaviorSubject } from 'rxjs';
import * as jwt_decode from 'jwt-decode';


@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService {

  private clienteAtualSubject : BehaviorSubject<Cliente>
  = new BehaviorSubject<Cliente>( JSON.parse( localStorage.getItem('usuarioAtual') ) );

  constructor(
    private http : HttpClient
  ) { }

  login( email : string, senha : string ) {
    let body = { email: email, senha : senha };

    return this.http.post<Cliente> ( `${environment.apiUrl}/auth/login`, body )
      .pipe (
        map(
          response => {
            console.log ( response );
            let decodificado = jwt_decode ( response.token);
            let cliente : Cliente = { nome : decodificado.nome, email : decodificado.sub, token: response.token  };         
            localStorage.setItem ('usuarioAtual', JSON.stringify ( cliente ) );
            this.clienteAtualSubject.next( cliente );
          }
        )
      );
  }

  logout(){
    localStorage.removeItem('usuarioAtual');
    this.clienteAtualSubject.next ( null );
  }

  public getClienteAtualSubject(){
    return this.clienteAtualSubject;
  }
}
