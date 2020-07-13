import { Component, OnInit } from '@angular/core';
import { AutenticacaoService } from '../auth/services/autenticacao.service';
import { Router } from '@angular/router';
import { Cliente } from '../shared/models/cliente';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  usuarioAtual : Cliente;

  constructor(
    private autenticacaoService : AutenticacaoService,
    private router : Router
    ) { }

  ngOnInit(): void {
    this.autenticacaoService
      .getClienteAtualSubject()
      .subscribe(
        (usuario) => {
          this.usuarioAtual = usuario;
        }
      );
  }

  logout(){
    this.autenticacaoService.logout();
    this.router.navigate ( [ '/auth/login' ] );
  }

}