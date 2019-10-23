// this is course service comp.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

// courses class
export class Courses {
  constructor(
    public coursesId: number,
    public description: string
  ) {}
}
// students class
export class Students {
  constructor(
    public studentId: number,
    public name: string
  ) {}
}



@Injectable({
  providedIn: 'root'
})

export class ServiceComponent {
  constructor(
    private httpClient: HttpClient
  ) {}

  // get courses schedule
  getCourses() {
    console.log('populating courses table');
    console.log(this.httpClient.get<Courses[]>('http://localhost:8082/course/all'));
    return this.httpClient.get<Courses[]>('http://localhost:8082/course/all');
  }

  // get students roster
  getStudents() {
    console.log('populating students table');
    console.log(this.httpClient.get<Students[]>('http://localhost:8082/student/all'));
    return this.httpClient.get<Students[]>('http://localhost:8082/student/all');
  }
}







