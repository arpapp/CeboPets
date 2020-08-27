import { Component, OnInit } from '@angular/core';
import { CebopetService } from 'src/app/services/cebopet.service';
import { NgForm } from '@angular/forms';
import { Cebopet } from 'src/app/models/cebopet';

@Component({
  selector: 'app-create-cebopet',
  templateUrl: './create-cebopet.component.html',
  styleUrls: ['./create-cebopet.component.css']
})
export class CreateCebopetComponent implements OnInit {

  constructor(
    private cebopetServ: CebopetService
  ) { }

  ngOnInit(): void {
  }

  createCebopet(form: NgForm){
    const cebopet: Cebopet = form.value;

    this.cebopetServ.createCebopet(cebopet).subscribe(
      data => {
        console.log('cebopet created')
      },
      err => {
        console.error('cebopet creation failure')
      }
    )
  }

}
