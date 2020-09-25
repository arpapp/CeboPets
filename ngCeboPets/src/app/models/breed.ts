export class Breed {
  id: number;
  name: string;
  pictureUrl: string;
  trait: string;

  constructor(id?: number, name?: string, pictureUrl?: string, trait?: string){
    this.id = id;
    this.name = name;
    this.pictureUrl = pictureUrl;
    this.trait = trait;
  }
}
