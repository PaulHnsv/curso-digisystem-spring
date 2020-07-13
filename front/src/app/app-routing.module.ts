import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PrimeiroComponent } from './primeiro/primeiro.component';
import { GuardService } from './auth/services/guard.service';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path:'primeiro', component : PrimeiroComponent },
  //lazyload
  { path:'produtos' , loadChildren : () => import ('./produtos/produtos.module').then ( m => m.ProdutosModule  ),
  canActivate : [ GuardService ]
},
  { path: 'auth', loadChildren : () => import( './auth/auth.module' ).then ( m =>m.AuthModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
