import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  Login = new FormGroup({
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  })
  error = false

  get email() { return this.Login.get('email') }
  get password() { return this.Login.get('password') }

  constructor(private product: ProductService, private router: Router) { }

  ngOnInit(): void {
  }
  r: any

  login() {
    console.log(this.Login.value)

    this.product.getlogin(this.Login.value.email).subscribe((result) => {
      console.warn(result)
      this.r = result

      if (result == null) {

        this.error = true
      }
      else {

        if (this.r.password == this.Login.value.password) {
          localStorage.setItem("logged", "true")
          this.router.navigate(['']);

        }
        else {
          this.error = true
        }
      }



    })



  }



}



