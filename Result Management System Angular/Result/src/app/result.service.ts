import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn:'root'
})
@Injectable({
  providedIn: 'root'
})
export class ResultService {

  url="http://localhost:4300/"


  constructor(private http:HttpClient) { }
  getList()
  {
    return this.http.get(this.url+"viewall");

  }

  getresult(rollno: any)
  {
    return this.http.get(this.url+"viewresult/"+rollno);

  }
 getTeacher(data: any)
  {
    return this.http.post(this.url+"teacherlogin",data);
    
  }

 getStudent(data: any)
  {
    return this.http.post(this.url+"studentlogin",data);

  }

  getAddStudent(data: any)
  {
    return this.http.post(this.url+"addstudent",data);

  }

  getedit(data :any)
  {
    return this.http.post(this.url+"edit",data);

  }

  delete(rollno: any)
  {
    return this.http.get(this.url+"delete/"+rollno);

  }
}
