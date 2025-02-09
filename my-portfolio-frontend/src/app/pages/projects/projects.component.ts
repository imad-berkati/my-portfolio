import { Component } from '@angular/core';
import { OnInit } from '../../../../node_modules/@angular/core/index';
import { ProjectDto, ProjectSummaryDto } from '../../../generated-api-client-v1/index';
import { ProjectService } from '../../core/services/project.service';
import { MatChipsModule } from '@angular/material/chips';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [MatChipsModule, CommonModule],
  providers: [DatePipe],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.scss'
})
export class ProjectsComponent implements OnInit {

  project: ProjectDto | null = null;

  projectSummaries: ProjectSummaryDto[] = [];

  constructor(private projectService: ProjectService, private datePipe: DatePipe) { }

  ngOnInit(): void {
    console.log('inside projects component');
    this.getProjectsSummaries();
    this.loadProjectById(2);
  }

  formatDate(date: string | null): string {
    return date ? this.datePipe.transform(date, 'MM/yyyy')! : 'present';
  }

  private loadProjectById(id: number) {
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

  private getProjectsSummaries(): void {
    this.projectService.getProjectsSummaries().subscribe({
      next: (data) => {
        this.projectSummaries = data;
      },
      error: (err) => {
        console.error('Failed to load projects summaries:', err);
      }
    });
  }

}
