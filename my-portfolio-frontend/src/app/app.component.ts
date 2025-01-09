import { Component, HostListener } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ProjectsComponent } from './pages/projects/projects.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav'
import { SkillsComponent } from './pages/skills/skills.component';
import { TestimonialsComponent } from './pages/testimonials/testimonials.component';
import { AboutComponent } from './pages/about/about.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
     AboutComponent, ProjectsComponent, SkillsComponent, TestimonialsComponent,
      MatSlideToggleModule, MatToolbarModule, MatIconModule, MatButtonModule, MatSidenavModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  isScrolled = false;

  @HostListener('window:scroll', [])
  onWindowScroll(): void {
    const offset = window.scrollY || document.documentElement.scrollTop;
    this.isScrolled = offset > 50;
  }
}
