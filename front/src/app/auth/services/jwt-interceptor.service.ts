import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AutenticacaoService } from './autenticacao.service';
import { Cliente } from 'src/app/shared/models/cliente';

@Injectable({
  providedIn: 'root'
})
export class JwtInterceptorService implements HttpInterceptor {

  constructor(private autenticacaoService : AutenticacaoService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    let usuarioAtual : Cliente = this.autenticacaoService.getClienteAtualSubject()?.value;

    if (usuarioAtual && usuarioAtual.token){
      request = request.clone({
        setHeaders: {
            Authorization: `Bearer ${usuarioAtual.token}`
        }
      });
    }

    return next.handle(request);
  }
}