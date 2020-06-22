import { Component, OnInit } from '@angular/core';
import { DiverService } from '../../services/diver.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-home',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  diverform: FormGroup;
  validMessage: string = "";

  constructor(private diverService: DiverService) { }

  ngOnInit(){
  this.diverform = new FormGroup({
  name: new FormControl('', Validators.required),
  phone: new FormControl('', Validators.required),
  email: new FormControl('', Validators.required),
  password: new FormControl('', Validators.required),
  gender: new FormControl(),
  birthday: new FormControl(),
  certified: new FormControl('', Validators.required),
  totalDives: new FormControl('', Validators.required),
  organization: new FormControl('', Validators.required),
  country: new FormControl('', Validators.required)
  });
  }

  submitRegistration(){
  if (this.diverform.valid){
    this.validMessage = "Thank you for joining our diver network!";
    this.diverService.createDiverRegistration(this.diverform.value).subscribe(
    data => {
    this.diverform.reset();
    return true;
    },
    error => {
      return Observable.throw(error);
    }
    )
  } else {
    this.validMessage = "Please fill out the required fields before submitting."
  }
  }

}
