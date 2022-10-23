import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Proyectos } from 'src/app/models/proyectos';
import { AutenticacionService } from 'src/app/services/autenticacion.service';
import { ProyectosService } from 'src/app/services/proyectos.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  public proyectoss: Proyectos[]=[];
  public editProyecto: Proyectos | undefined;
  public deleteProyecto: Proyectos | undefined;

  constructor(private proyectosService: ProyectosService, public autenticacionService: AutenticacionService) { }

  isloged = () => this.autenticacionService.loggedIn();
  
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

  public onOpenModal(mode: String, proyectos?: Proyectos): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addProyectosModal');
    } else if (mode === 'delete') {
      this.deleteProyecto = proyectos;
      button.setAttribute('data-bs-target', '#deleteProyectosModal');
    } else if (mode === 'edit') {
      this.editProyecto = proyectos;
      button.setAttribute('data-bs-target', '#editProyectosModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddProyecto(addForm: NgForm): void {
    document.getElementById('add-proyecto-form')?.click();
    this.proyectosService.addProyectos(addForm.value).subscribe({
      next:(response:Proyectos) => {
        console.log(response);
        this.getProyecto();
        addForm.reset();
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateProyecto(proyectos: Proyectos): void {
    this.editProyecto = proyectos;
    this.proyectosService.updateProyectos(proyectos).subscribe({
      next:(response:Proyectos)=>{
        console.log(response);
        this.getProyecto();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  public onDeleteProyecto(idPro: number):void{
    this.proyectosService.deleteProyectos(idPro).subscribe({
      next:(response:void)=>{
        console.log(response);
        this.getProyecto();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  onDrop(event: CdkDragDrop<Proyectos[]>) {
    if (this.autenticacionService.loggedIn()) {
      if (event.previousContainer === event.container) {
        moveItemInArray(
          event.container.data,
          event.previousIndex,
          event.currentIndex
        );
      } 
    }
  }

}
