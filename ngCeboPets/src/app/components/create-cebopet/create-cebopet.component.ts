import { Component, OnInit } from '@angular/core';
import { CebopetService } from 'src/app/services/cebopet.service';
import { NgForm } from '@angular/forms';
import { Cebopet } from 'src/app/models/cebopet';
import { Breed } from 'src/app/models/breed';
import { BreedService } from 'src/app/services/breed.service';

@Component({
  selector: 'app-create-cebopet',
  templateUrl: './create-cebopet.component.html',
  styleUrls: ['./create-cebopet.component.css']
})
export class CreateCebopetComponent implements OnInit {

  constructor(
    private cebopetServ: CebopetService,
    private breedServ: BreedService
  ) { }

  breed: Breed = null;


  ngOnInit(): void {
  }



  setBreedForCeboCreation(breedName: string){

    return this.breedServ.fetchBreed(breedName).subscribe(
      data => {
        this.breed = data;
        console.log('breed selected succesfully');
      },
      err => {
        console.error('breed select failed');
      }
    )
  }

  createCebopet(form: NgForm){
    const cebopet: Cebopet = form.value;

    console.log(this.breed + "you are here");

    cebopet.breed = this.breed;


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
