export class User {
  id: number;
  username: string;
  password: string;
  firstName: string;
  lastName: string;
  enabled: boolean;

  constructor(id?: number, username?: string, password?: string, firstName?: string, lastName?: string, enabled?: boolean ){
    this.id = id;
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.enabled = enabled;
  }
}
