import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sorting',
  styleUrls: ['./sorting.component.css'],
  template:`
  <div class = "toggle-panel" *ngIf = "show" [hidden] = "hidden">
    Toggle Me
  </div>

  <button> (click) = "toggleShow()">Show</button>
  <button> (click) = "toggleShow()">Hidden</button>

  `
  
})
export class SortingComponent implements OnInit {

  constructor() { }

  show = true;
  hidden = false;

  toggleShow()
  {
    this.show = !this.show;
  }
  toggleHidden()
  {
    this.hidden = !this.hidden;
  }
  
  ngOnInit() {
  }



  //sort number arrays 
  

}
