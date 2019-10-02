import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-component',
  templateUrl: './demo-component.component.html',
  styleUrls: ['./demo-component.component.css']
})
export class DemoComponentComponent implements OnInit 
{
  constructor() { }

  //SHOW BUTTON
  showbutton1 = false;
  public showPalindrome():void
  {
    this.showbutton1 = !this.showbutton1;
  }

  //checking reverse string method
  string: string;
  output: string;
  flag: number = 1;// using flags as checkers
  isPalindrome(): void 
  {
    let length = this.string.length - 1;
    this.flag = 1;
    for (let k = 0; k < length / 2; k++) 
    {
      if (this.string.charAt(k) != this.string.charAt(length)) 
      {
        this.output = "Try again! Not a Palindrome";
        console.log("Try again! Not a Palindrome");
        this.flag = 0;
        break;
      }
      length--; // check  if reverse string matches
    }
    if (this.flag === 1) 
    {
      this.output = this.string + " is a Palindrome";
      console.log(this.string + " is a Palindrome");
    }
  }

  ngOnInit() {
  }

}