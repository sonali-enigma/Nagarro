import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ProductService } from '../product.service';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.sass']
})
export class SearchProductComponent implements OnInit {

  searchProduct = new FormGroup({
    search: new FormControl('', Validators.required),
  
  })
  error = false

  get search() { return this.searchProduct.get('search') }
  
  

  constructor(private product: ProductService, private router: Router) { }

  ngOnInit(): void {
  }

  logout()
  {
    localStorage.setItem("logged","false")
    this.router.navigate(['']);
  }
}
