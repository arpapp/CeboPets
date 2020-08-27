import { Breed } from './breed';

export class Cebopet {
  id: number;
  name: string;
  hungerLevel: number;
  gender: string;
  enabled: boolean;
  breed: Breed;

  constructor(id?: number, name?: string,
    hungerLevel?: number, gender?: string, enabled?: boolean, breed?: Breed){
      this.id = id;
      this.name = name;
      this.hungerLevel = hungerLevel;
      this. gender = gender;
      this.enabled = enabled;
      this.breed = breed;
    }
}
