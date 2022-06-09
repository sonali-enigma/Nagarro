import { Component, ComponentFactoryResolver, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ResultService } from '../result.service';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-student-login',
  templateUrl: './student-login.component.html',
  styleUrls: ['./student-login.component.css']
})
export class StudentLoginComponent implements OnInit {

  studentLogin = new FormGroup({
    name: new FormControl('', Validators.required),
    rollno: new FormControl('', Validators.required)
  })
  error = false

  get name() { return this.studentLogin.get('name') }
  get rollno() { return this.studentLogin.get('rollno') }

  constructor(private result: ResultService, private router: Router) { }

  ngOnInit(): void {
  }
  r: any
  r1: any
  login() {
    this.result.getStudent(this.studentLogin.value).subscribe((result) => {
      console.warn(result)
      console.warn(this.studentLogin.value)
      this.r = result
      this.r1 = this.studentLogin.value

      if (this.r["message"] == "valid") {
        localStorage.setItem("logged", "true")
        this.router.navigate(['/viewresult/' + this.r1.rollno]);
      }
      else
        this.error = true


    })


  }
}
