import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AutenticacaoService } from './autenticacao.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(
    private autenticacaoService : AutenticacaoService,
    private router : Router
     ) { }

  canActivate() : boolean {

    let usuarioAtual = this.autenticacaoService.getClienteAtualSubject()?.value;

    if (usuarioAtual){
      return true;
    }

    this.router.navigate ( ['/auth/login'] );

    return false;
  }
}
