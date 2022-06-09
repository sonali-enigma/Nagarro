import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';
import { ResultService } from '../result.service';


@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  addStudent=new FormGroup({
    rollno:new FormControl('', [Validators.required,Validators.pattern('[0-9]*')]),
    name: new FormControl('', [Validators.required,Validators.pattern('[a-zA-Z ]*')]),
    dob:new FormControl('',Validators.required),
    score:new FormControl('', [Validators.required,Validators.pattern('[0-9]*')]),
    
  })

  error=false
  

  get rollno(){return this.addStudent.get('rollno')}
  get name(){return this.addStudent.get('name')}
  get dob(){return this.addStudent.get('dob')}
  get score(){return this.addStudent.get('score')}
  
  constructor(private router: ActivatedRoute, private result: ResultService ,private routers: Router) { }

  r:any
  ngOnInit(): void {
    if(localStorage.getItem("logged")=="false"){
      this.routers.navigate(['/teacherlogin']);
    }
  }
  add()
  {
    
    console.warn(this.addStudent.value)
    this.result.getAddStudent(this.addStudent.value).subscribe((result)=>{
    console.log(result)
    this.r=result

    if (this.r["message"]=="Already exist")
    {
      this.error=true
      console.warn("Already exist")
    }
    else{
    this.routers.navigate(['/viewall']);
    console.warn("Added Successfully")
    }


})

  }
  logout()
  {
    localStorage.setItem("logged","false")
    this.routers.navigate(['/teacherlogin']);
  }
}
