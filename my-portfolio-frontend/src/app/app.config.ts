import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';

import { routes } from './app.routes';
import { Configuration } from '../generated-api-client-v1/configuration';
import { ApiModule } from '../generated-api-client-v1/api.module';

export const appConfig: ApplicationConfig = {
  providers: [provideZoneChangeDetection({ eventCoalescing: true }),
     provideRouter(routes),
     provideHttpClient(),
     {
      provide: Configuration,
      useValue: new Configuration({
        basePath : 'http://localhost:8585/api/v1'
      }) // TODO : This configuration is only for localhost and development purposes. Replace this dynamic config from environments config files
    },
    ApiModule,
    ]
};
