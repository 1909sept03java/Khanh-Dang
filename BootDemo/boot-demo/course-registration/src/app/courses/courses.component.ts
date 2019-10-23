import { Component, OnInit } from '@angular/core';
import {ServiceComponent} from '../service/service.component';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  Courses: any[];
  Courses1: any[] = [];
  // tslint:disable-next-line:no-shadowed-variable
  constructor(private CoursesServiceComponent: ServiceComponent) { }
  ngOnInit() {
    this.loadtable();
  }

  loadtable() {
    // original was i = 10
    for (let i = 0; i < 7; i++) {
      this.CoursesServiceComponent.getCourses().subscribe(
        response => this.handleSuccessfulResponse(response),
      );
    }
  }

  handleSuccessfulResponse(response) {
    this.Courses = response;
    console.log(response);
    // original was i = 10
    for (let i = 0; i < 17; i++) {
      // this.Courses.push(this.Courses[i]);
      this.Courses1.push(this.Courses[i]);
    }
  }
}






