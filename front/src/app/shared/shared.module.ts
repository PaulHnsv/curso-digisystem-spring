
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { sharedRoutingModule } from './shared-routing.module';
import { FormErrorsComponent } from './form-errors/form-errors.component';
import { HightlightDirective } from './diretivas/hightlight.directive';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

//import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [
    FormErrorsComponent,
    HightlightDirective
  ],
  imports: [
    CommonModule,
    sharedRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  //  BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot() // ToastrModule added
  ],
  exports : [
    FormErrorsComponent,
    HightlightDirective,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule,
//	BrowserAnimationsModule
  ]
})
export class SharedModule { }