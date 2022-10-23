import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Educacion } from 'src/app/models/educacion';
import { AutenticacionService } from 'src/app/services/autenticacion.service';
import { EducacionService } from 'src/app/services/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

  public educations: Educacion[] = [];
  public editEducation: Educacion | undefined;
  public deleteEducation: Educacion | undefined;

  constructor(private educacionService: EducacionService,
    public autenticacionService: AutenticacionService) { }

    isloged = () => this.autenticacionService.loggedIn();
  ngOnInit(): void {
    this.getEducation();
  }


  public getEducation(): void {
    this.educacionService.getEducation().subscribe({
      next: (response: Educacion[]) => {
        this.educations = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    })
  }
  public onOpenModal(mode: String, educacion?: Educacion): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addEducationModal');
    } else if (mode === 'delete') {
      this.deleteEducation = educacion;
      button.setAttribute('data-bs-target', '#deleteEducationModal');
    } else if (mode === 'edit') {
      this.editEducation = educacion;
      button.setAttribute('data-bs-target', '#editEducationModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddEducation(addForm: NgForm): void {
    document.getElementById('add-education-form')?.click();
    this.educacionService.addEducation(addForm.value).subscribe({
      next:(response:Educacion) => {
        console.log(response);
        this.getEducation();
        addForm.reset();
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateEducation(educacion: Educacion): void {
    this.editEducation = educacion;
    this.educacionService.updateEducation(educacion).subscribe({
      next:(response:Educacion)=>{
        console.log(response);
        this.getEducation();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  public onDeleteEducation(idEdu: number):void{
    this.educacionService.deleteEducation(idEdu).subscribe({
      next:(response:void)=>{
        console.log(response);
        this.getEducation();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  onDrop(event: CdkDragDrop<Educacion[]>) {
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
