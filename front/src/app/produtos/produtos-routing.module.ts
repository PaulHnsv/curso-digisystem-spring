import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutosListComponent } from './produtos-list/produtos-list.component';
import { ProdutoFormComponent } from './produto-form/produto-form.component';


const routes: Routes = [
  { path: '', component: ProdutosListComponent },
  { path : 'novo' , component : ProdutoFormComponent },
  { path : ':id' , component : ProdutoFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
