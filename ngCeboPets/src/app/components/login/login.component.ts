import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private auth:AuthService
  ) { }

  ngOnInit(): void {
  }

  login(form: NgForm){
    const user = form.value.username;
    const pw = form.value.password;
    this.auth.login(user, pw).subscribe(
      data => {
        console.log('LoginComponent.login(): user logged in.');
        // this.router.navigateByUrl('/home');
          },
          error => {
            console.error('login() component: error logging in.');
            window.alert('Account has been deactivated, please email admin@stockoverflow.com to reactivate it if desired!');
          }
        );
      }

}
