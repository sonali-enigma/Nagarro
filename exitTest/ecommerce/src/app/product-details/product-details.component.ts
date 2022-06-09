import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute } from '@angular/router';
import { Router, RouterModule, Routes } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.sass']
})
export class ProductDetailsComponent implements OnInit {

  pincode = new FormGroup({
    Pincode: new FormControl('', Validators.required),


  })
  error = false

  constructor(private routers: ActivatedRoute, private product: ProductService, private router: Router) { }

  products: any
  r: any
  yes=false;
  no=false;
  days:any;
  ngOnInit(): void {
    if(localStorage.getItem("logged")=="false"){
      this.router.navigate(['/login']);
    }
    console.warn(this.routers.snapshot.params['id'])
    this.product.getID(this.routers.snapshot.params['id']).
      subscribe((result) => {

        this.products = result
       

      }
      )
  }

  back() {

    this.router.navigate(['']);
  }

  Pcode() {
   

    this.yes=false
    this.no=false
    this.product.getpincode(this.routers.snapshot.params['id'], this.pincode.value.Pincode).
      subscribe((result) => {

       console.log(result)
       this.r=result
      if(this.r.length>0){
        this.yes=true;
        this.days=this.r[0].estimateddays;

      }
      else{
        this.no=true;
      }



      })
  }
}
