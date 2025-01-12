import { Component } from '@angular/core';
import { OnInit } from '../../../../node_modules/@angular/core/index';
import { ProjectDto } from '../../../generated-api-client-v1/index';
import { ProjectService } from '../../core/services/project.service';
import {MatChipsModule} from '@angular/material/chips';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [MatChipsModule],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.scss'
})
export class ProjectsComponent implements OnInit {

  project: ProjectDto | null = null;

  constructor(private projectService : ProjectService) {}

  ngOnInit(): void {
    console.log('inside projects component');
    this.loadProjectById(1);
  }

  private loadProjectById(id : number) {
    this.projectService.getProjectById(id).subscribe({
      next: (data) => {
        this.project = data;
        console.log('Project loaded:', data);
      },
      error: (err) => {
        console.error('Failed to load project:', err);
      }
    });
  }

}
