import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../produto.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.scss']
})
export class ProdutoFormComponent implements OnInit {

  formulario : FormGroup;
  id_produto : number ;
  isEdition : boolean = false;
  buttonText: string = 'Salvar';
  

  constructor(
    private activatedRoute : ActivatedRoute,
    private produtoService : ProdutoService,
    private router : Router,
    private formBuilder : FormBuilder,
    private toastr : ToastrService
      ) {

        this.formulario = this.formBuilder
          .group(
            {
              nome : [  null , [ Validators.required ]  ],
              preco : [ null, [ Validators.required  ] ]
            }
        );

  }

  ngOnInit(): void {

    //console.log ( this.activatedRoute );
    this.activatedRoute.params
      .subscribe (
        ( rotaParams ) => {
          //console.log ( rotaParams.id );

          if ( rotaParams.id ){
            //é edição
            this.id_produto = rotaParams.id;
            this.isEdition = true;
            this.buttonText = 'Alterar';
            this.get ( rotaParams.id );
            
          }

        }
      );
  }

  onSubmit(){
    //alert('Submitted');

    if (this.isEdition == true){

      this.produtoService
      .update( this.id_produto, this.formulario.value )
      .subscribe (
        (reponse) => {
          //alert ('Produto alterado com sucesso');
          this.toastr.success ("Produto alterado com sucesso");
          this.router.navigate (['produtos']);
        },
        ( error ) => {
          this.toastr.error ( 'Erro ao alterar produto!' );
        }
      ) ;
    }
    else{
      this.produtoService
        .create ( this.formulario.value )
        .subscribe(
          (response) => {
            this.produtoService.getProdutoBarramento().next( response );
            this.toastr.success( 'Produto Criado com sucesso' );
            this.router.navigate (['produtos']);
          }
        );
    }



  }

  isFieldValid( nomeField ){
    return !this.formulario.get( nomeField ).valid && this.formulario.get( nomeField ).touched;
  }

  private get( id ){
    this.produtoService.get ( id ).subscribe (
      ( response ) => {
        console.log ( response );
        //{  nome : "PRODUTO TESTE" , preco : 200  }
        this.formulario.patchValue( response );

      }
    );
  }

}

