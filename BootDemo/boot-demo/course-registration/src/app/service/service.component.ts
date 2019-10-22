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
@Injectable({
  providedIn: 'root'
})

export class ServiceComponent {
  constructor(
    private httpClient: HttpClient
  ) {}

  getCourses() {
    console.log('populating table');
    console.log(this.httpClient.get<Courses[]>('http://localhost:8082/course/all'));
    return this.httpClient.get<Courses[]>('http://localhost:8082/course/all');
  }
}







