import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sorting',
  templateUrl: './sorting.component.html',
  providers: [SortingComponent], // use providers to avoid unspecified template
  styleUrls: ['./sorting.component.css']
})
export class SortingComponent implements OnInit 
{
  constructor() { }

  //sort number arrays 
  string: string;
  output: string;
  sortArray(): void 
  {
    let array = this.string.split(',').map(function (item) { //allow user to insert , between numbers
      return parseInt(item, 10);
    });
    this.output = "Sorted list: " + array.sort(function (a, b) { return a - b });
    console.log(array.sort(function (a, b) { return a - b }));
  }

  ngOnInit() {
  }

}
