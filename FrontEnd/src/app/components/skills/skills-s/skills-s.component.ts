import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SkillsS } from 'src/app/models/skillss';
import { AutenticacionService } from 'src/app/services/autenticacion.service';
import { SkillssService } from 'src/app/services/skillss.service';

@Component({
  selector: 'app-skills-s',
  templateUrl: './skills-s.component.html',
  styleUrls: ['./skills-s.component.css']
})
export class SkillsSComponent implements OnInit {
  public skillssoft:SkillsS[]=[];
  public skillssoft2 = this.skillssService.getSkillsS();
  public editskillssoft: SkillsS | undefined;
  public deleteskillssoft: SkillsS | undefined;

  constructor(private skillssService:SkillssService, public autenticacionService: AutenticacionService) { }

  isloged = () => this.autenticacionService.loggedIn();
  ngOnInit(): void {
    this.getSkillssoft();
  }

  public getSkillssoft():void{
    this.skillssService.getSkillsS().subscribe({
      next:(Response:SkillsS[])=>{
        this.skillssoft=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode: String, skillss?: SkillsS): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addSkillsSModal');
    } else if (mode === 'delete') {
      this.deleteskillssoft = skillss;
      button.setAttribute('data-bs-target', '#deleteSkillsSModal');
    } else if (mode === 'edit') {
      this.editskillssoft = skillss;
      button.setAttribute('data-bs-target', '#editSkillsSModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddSkillsSoft(addForm: NgForm): void {
    document.getElementById('add-skillssoft-form')?.click();
    this.skillssService.addSkillsS(addForm.value).subscribe({
      next:(response:SkillsS) => {
        console.log(response);
        this.getSkillssoft();
        addForm.reset();
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateSkillsSoft(skillss: SkillsS): void {
    this.editskillssoft = skillss;
    this.skillssService.updateSkillsS(skillss).subscribe({
      next:(response:SkillsS)=>{
        console.log(response);
        this.getSkillssoft();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  public onDeleteSkillsSoft(idSkillS: number):void{
    this.skillssService.deleteSkillsS(idSkillS).subscribe({
      next:(response:void)=>{
        console.log(response);
        this.getSkillssoft();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }
  
  onDrop(event: CdkDragDrop<SkillsS[]>) {
    if (this.autenticacionService.loggedIn()) {
      if (event.previousContainer === event.container) {
        moveItemInArray(
          event.container.data,
          event.previousIndex,
          event.currentIndex
        );
      } else {
        transferArrayItem(
          event.previousContainer.data,
          event.container.data,
          event.previousIndex,
          event.currentIndex
        );
      }
    }
  }

}
