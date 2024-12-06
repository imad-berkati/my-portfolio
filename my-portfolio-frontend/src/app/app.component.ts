import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProjectsComponent } from './pages/projects/projects.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, ProjectsComponent, MatSlideToggleModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'my-portfolio-frontend';
}
