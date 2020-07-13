import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Produto } from './shared/produto';
import { environment } from 'src/environments/environment';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  
  private produtoBarramento : Subject<Produto> = new Subject<Produto>();

  url : String = `${environment.apiUrl}/produtos`;

  constructor( private http : HttpClient ) { }

  getAll(){
    //return [
    //  { id : 1, nome: 'Produto 1', preco: 100 },
    //  { id : 2, nome: 'Produto 2', preco: 200 },
    //  { id : 3, nome: 'Produto 3', preco: 300 },
    //  { id : 4, nome: 'Produto 4', preco: 400 }
    // ];
    return this.http.get<Produto[]> ( `${this.url}` );

  }
  
  get( id ){
    //return this.http.get ( 'http://localhost:8080/produtos/' + id );
  return this.http.get<Produto> ( `${this.url}/${id}` );
  }

  //get( id ){
  //  return this.http.get ( `http://localhost:8080/produtos/${id}` );

  update( id, produto ){
    return this.http
    .put<Produto> (`${this.url}/${id}`, produto );
    }

    create( produto ){
      return this.http
      .post<Produto> ( `${this.url}`, produto );
      }

      delete( id ){
        //return this.http.get ( `http://localhost:8080/produtos/${id}` );
        return this.http
        .delete ( `${this.url}/${id}` );
        }

        getProdutoBarramento() : Subject<Produto>{
          return this.produtoBarramento;
          }
}
