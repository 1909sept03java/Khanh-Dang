import { NgModule } from '@angular/core';
import { Routes, RouterModule, Router } from '@angular/router';
import { StudentsComponent} from './students/students.component';
import {CoursesComponent} from './courses/courses.component';
import {ServiceComponent} from './service/service.component';

// tslint:disable-next-line:max-line-length
const routes: Routes = [{ path: 'course', component: CoursesComponent}, { path: 'student', component: StudentsComponent}, { path: 'service', component: ServiceComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {constructor(private router: Router) {} }
