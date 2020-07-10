import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: 'p[hightlight]'
})
export class HightlightDirective {
  //private el : ElementRef;

  constructor( private el : ElementRef, private renderer : Renderer2 ) {
    //console.log ( this.el );
    //this.el.nativeElement.style.backgroundColor = 'yellow';
  }

  @HostBinding ('style.background-color')
  private minhaCor : string;

  @HostListener('mouseenter')
  onMouseEnter(){
    //console.log ( 'mouseenter');
    //this.renderer.setStyle( this.el.nativeElement, 'background-color', 'blue' );
    this.minhaCor = 'blue';
  }

  @HostListener('mouseleave')
  onMouseLeave(){
    //console.log ( 'mouseleave');
    //this.renderer.setStyle( this.el.nativeElement, 'background-color', 'white' );
    this.minhaCor = 'white';
  }

}
