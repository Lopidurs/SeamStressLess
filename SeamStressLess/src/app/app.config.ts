import {ApplicationConfig, importProvidersFrom, provideZoneChangeDetection} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import {provideHttpClient, withInterceptors} from "@angular/common/http";
import {endpointInterceptor} from "./core/interceptors/endpoint.interceptor";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {provideAnimations} from "@angular/platform-browser/animations";
import {MatNativeDateModule} from "@angular/material/core";

export const appConfig: ApplicationConfig = {
  providers: [
    provideAnimations(),
    importProvidersFrom(MatNativeDateModule),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideHttpClient(withInterceptors([endpointInterceptor])), provideAnimationsAsync(),
  ]
};
