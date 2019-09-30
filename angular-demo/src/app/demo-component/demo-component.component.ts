import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-component',
  templateUrl: './demo-component.component.html',
  styleUrls: ['./demo-component.component.css']
})
export class DemoComponentComponent implements OnInit {

  constructor() { }

  // property of DemoComponentComponent
  user = {
    section: '',
    newSection: ''
    
  };

  // function invoked in event binding demo
  submitComment()
  {
    //if is palindrome 
    this.user.section += this.user.newSection;
  }

  //checking reverse string
  isPalindrome(str:string) 
  {
    return str.split('').reverse().join('') === str;
  }

  

  ngOnInit() {
  }

}