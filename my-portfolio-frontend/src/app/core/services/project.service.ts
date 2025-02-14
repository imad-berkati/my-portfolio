import { Injectable } from '@angular/core';
import { Observable } from '../../../../node_modules/rxjs/dist/types/index';
import { ProjectDto, ProjectsOpenApiService, ProjectSummaryDto } from '../../../generated-api-client-v1/index';


@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private projectsOpenApiService: ProjectsOpenApiService ) { }

  public getProjectById(id : number) : Observable<ProjectDto> {
    return this.projectsOpenApiService.getProjectById(id);
  }

  public getProjectsSummaries() : Observable<Array<ProjectSummaryDto>> {
    return this.projectsOpenApiService.getProjectsSummaries();
  }

}
