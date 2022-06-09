import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { ResultService } from '../result.service';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-viewall',
  templateUrl: './viewall.component.html',
  styleUrls: ['./viewall.component.css']
})
export class ViewallComponent implements OnInit {

  constructor(private result: ResultService,private router:Router) { }

  r: any
  collection: any = [];
  ngOnInit(): void {
    if(localStorage.getItem("logged")=="false"){
      this.router.navigate(['/teacherlogin']);
    }
    this.result.getList().subscribe((result) => {
      console.warn(result)
      this.r = result
      this.collection = this.r["data"]

    })
  }

  delete(rollno: any) {
this.result.delete(rollno).subscribe((result)  =>{

  window.location.reload()

})
  }

  logout()
  {
    localStorage.setItem("logged","false")
    this.router.navigate(['/teacherlogin']);
  }
}


