import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/models/persona';
import { AcercaService } from 'src/app/services/acerca.service';

@Component({
  selector: 'app-acerca',
  templateUrl: './acerca.component.html',
  styleUrls: ['./acerca.component.css']
})
export class AcercaComponent implements OnInit {
  public persona: Persona | undefined;
  public editPersona: Persona | undefined;

  constructor(private acercaService: AcercaService) { }


  ngOnInit(): void {
    this.getUser();
  }

  public getUser():void{
    this.acercaService.getUser().subscribe({
      next: (response: Persona) =>{
        this.persona=response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }


}
