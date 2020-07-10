import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { GuardService } from './auth/guard.service';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path:'primeiro', component : PrimeiroComponent },
  //lazyload
  { path:'produtos' , loadChildren : () => import ('./produtos/produtos.module').then ( m => m.ProdutosModule  ),
  canActivate : [ GuardService ]

}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
