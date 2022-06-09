import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ResultService } from '../result.service';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css']
})
export class EditStudentComponent implements OnInit {


  editResult = new FormGroup({
    rollno: new FormControl(''),
    name: new FormControl('', [Validators.required,Validators.pattern('[a-zA-Z ]*')]),
    dob: new FormControl('', Validators.required),
    score: new FormControl('',  [Validators.required,Validators.pattern('[0-9]*')]),

  })
  constructor(private router: ActivatedRoute, private result: ResultService ,private routers: Router) { }

  r: any
  ngOnInit(): void {
    if(localStorage.getItem("logged")=="false"){
      this.routers.navigate(['/teacherlogin']);
    }
    console.warn(this.router.snapshot.params['rollno'])
    this.result.getresult(this.router.snapshot.params['rollno']).
      subscribe((result) => {

        this.r = result
        console.warn(this.r.data)
        this.editResult = new FormGroup({
          rollno: new FormControl(this.r.data[0].rollno),
          name: new FormControl(this.r.data[0].name),
          dob: new FormControl(this.r.data[0].dob),
          score: new FormControl(this.r.data[0].score)



        })

      }
      )
  }
  
  edit() {
    this.result.getedit(this.editResult.value).subscribe((result)=>{
      console.log(result)
      this.routers.navigate(['/viewall']);


  })
  }
  logout()
  {
    localStorage.setItem("logged","false")
    this.routers.navigate(['/teacherlogin']);
  }
}

