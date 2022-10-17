import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/persona';
import { NavbarService } from 'src/app/services/navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})

export class NavbarComponent implements OnInit {


  public persona: Persona | undefined;
  public editPersona: Persona | undefined;

  constructor(private navbarService: NavbarService) { 

    }
    
  
  ngOnInit(): void {
    this.getUser();
  }



  public getUser():void{
    this.navbarService.getUser().subscribe({
      next: (response: Persona) =>{
        this.persona=response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode: String, Persona?: Persona): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    this.editPersona = this.persona;
      button.setAttribute('data-bs-target', '#editPersonaModal');

      container?.appendChild(button);
      button.click();
  }

  public onUpdatePersona(persona: Persona): void {
    this.editPersona = persona;
    this.navbarService.updatePersona(persona).subscribe({
      next:(response:Persona)=>{
        console.log(response);
        this.getUser();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

}
