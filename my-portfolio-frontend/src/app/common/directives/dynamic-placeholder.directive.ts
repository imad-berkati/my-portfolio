import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appDynamicPlaceholder]',
  standalone: true
})
export class DynamicPlaceholderDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
