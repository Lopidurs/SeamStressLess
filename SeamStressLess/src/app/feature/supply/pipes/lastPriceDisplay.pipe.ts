import { inject, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  standalone: true,
  name: 'lastPriceDisplay'
})

export class LastPriceDisplayPipe implements PipeTransform {
  transform(value: number): string {
    return value ? `$${value.toFixed(2)}` : ' -- ';
  }
}
