// src/app/pages/login/login.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { LoginModel } from '../../models/user.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginObj: LoginModel = new LoginModel();
  loading = false;

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    const loadingElement = document.getElementById('loading');
    const loginPageElement = document.getElementById('loginPage');
    
    if (loadingElement) {
      loadingElement.style.display = 'none';
    }

    setTimeout(() => {
      if (loginPageElement) {
        loginPageElement.style.opacity = '1';
        loginPageElement.style.transform = 'translateY(0)';
      }
    }, 1000);
  }

  onLogin() {
    this.loading = true;
    const loadingDashboardElement = document.getElementById('loadingDashboard');
    
    if (loadingDashboardElement) {
      loadingDashboardElement.style.display = 'flex';
    }

    this.authService.login(this.loginObj).subscribe(response => {
      localStorage.setItem('jwtToken', response.jwt);
      this.router.navigateByUrl('/dashboard');
    }, error => {
      alert("No User Found");
      this.loading = false;
      if (loadingDashboardElement) {
        loadingDashboardElement.style.display = 'none';
      }
    });
  }
}
