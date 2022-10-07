import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Proyectos } from 'src/app/models/proyectos';
import { ProyectosService } from 'src/app/services/proyectos.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  public proyectoss: Proyectos[]=[];

  constructor(private proyectosService: ProyectosService) { }

  ngOnInit(): void {
    this.getProyecto();
  }

  public getProyecto():void{
    this.proyectosService.getProyectos().subscribe({
      next:(Response: Proyectos[]) =>{
        this.proyectoss=Response;
      },
      error:(error:HttpErrorResponse) =>{
        alert(error.message);
      }
    })
  }

}
