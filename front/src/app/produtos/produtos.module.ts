import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProdutosRoutingModule } from './produtos-routing.module';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';
import { ProdutoDetalheComponent } from './produto-detalhe/produto-detalhe.component';
import { ProdutoFormComponent } from './produto-form/produto-form.component';
import { SharedModule } from '../shared/shared.module';

@NgModule({
  declarations: [ ProdutosListComponent, ProdutoDetalheComponent, ProdutoFormComponent ],
  imports: [
    CommonModule,
    ProdutosRoutingModule,
    SharedModule
  ],
  exports:[
    ProdutosListComponent
  ]
})
export class ProdutosModule { }
