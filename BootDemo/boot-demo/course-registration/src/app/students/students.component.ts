/* tslint:disable:no-trailing-whitespace */
import { Component, OnInit } from '@angular/core';
import {ServiceComponent} from '../service/service.component';


@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent implements OnInit {

  showbutton1 = false;
  showbutton2 = false;
  showbutton3 = false;

  Students: any[];
  Students1: any[] = [];

  Courses: any[];
  Courses1: any[] = [];

  constructor(private StudentsService: ServiceComponent, private CoursesService: ServiceComponent) { }

  ngOnInit() {
    this.loadStudentTable();
    this.loadCourseTable();
  }

  // load student table
  loadStudentTable() {
    for (let i = 0; i < 10; i++) {
      this.StudentsService.getStudents().subscribe(
        response => this.handleSuccessfulResponse(response),
      );
    }
  }

  // load student schedule
  loadCourseTable() {
    for (let i = 0; i < 10; i++) {
      this.CoursesService.getCourses().subscribe(
        response => this.handleSuccessfulResponse1(response),
      );
    }
  }

  // only for students
  handleSuccessfulResponse(response) {
    this.Students = response;
    console.log(response);
    for (let i = 0; i < 10; i++) {
      this.Students1.push(this.Students[i]);
    }
  }

  // only for courses
  handleSuccessfulResponse1(response) {
    this.Courses = response;
    console.log(response);
    for (let i = 0; i < 10; i++) {
      this.Courses1.push(this.Courses[i]);
    }
  }

  // SHOW ROSTER BUTTON
    public showRoster(): void {
    this.showbutton1 = !this.showbutton1;
  }

  // SHOW ROSTER BUTTON
  public showSchedule(): void {
    this.showbutton2 = !this.showbutton2;
  }

  // SHOW MODIFY SCHEDULE
  public showModSchedule(): void {
    this.showbutton3 = !this.showbutton3;
  }

}


