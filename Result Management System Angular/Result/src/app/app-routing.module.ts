import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { EditStudentComponent } from './edit-student/edit-student.component';
import { IndexComponent } from './index/index.component';
import { StudentLoginComponent } from './student-login/student-login.component';
import { TeacherLoginComponent } from './teacher-login/teacher-login.component';
import { ViewallComponent } from './viewall/viewall.component';
import { ViewresultComponent } from './viewresult/viewresult.component';

const routes: Routes = [
{
  component:AddStudentComponent,
  path:'addstudent'
},
{
  component:EditStudentComponent,
  path:'edit/:rollno'
},

{
  component:StudentLoginComponent,
  path:'studentlogin'
},
{
  component:TeacherLoginComponent,
  path:'teacherlogin'
},
{
  component:ViewallComponent,
  path:'viewall'
},
{
  component:ViewresultComponent,
  path:'viewresult/:rollno'
},
{
  component:IndexComponent,
  path:''
},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
