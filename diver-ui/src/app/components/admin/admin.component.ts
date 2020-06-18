import { Component, OnInit } from '@angular/core';
import { DiverService } from '../../services/diver.service'

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public divers;

  constructor(private diverService: DiverService) { }

  ngOnInit(){
  console.log("ngOnInit");
  this.getDivers();
  }

  getDivers(){
  this.diverService.getDivers().subscribe(
    data => { this.divers = data},
    err => console.error(err),
    () => console.log('divers loaded')
  )
  }

}
