import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SkillsB } from 'src/app/models/skillsb';
import { SkillsbService } from 'src/app/services/skillsb.service';

@Component({
  selector: 'app-skills-b',
  templateUrl: './skills-b.component.html',
  styleUrls: ['./skills-b.component.css']
})
export class SkillsBComponent implements OnInit {

  public skillsback:SkillsB[]=[];
  public skillsback2 = this.skillsbService.getSkillsB;
  public editskillsback: SkillsB | undefined;
  public deleteskillsback: SkillsB | undefined;

  constructor(private skillsbService:SkillsbService) { }

  ngOnInit(): void {
    this.getSkillsback();
  }

  public getSkillsback():void{
    this.skillsbService.getSkillsB().subscribe({
      next:(Response:SkillsB[])=>{
        this.skillsback=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode: String, skillsb?: SkillsB): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-bs-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-bs-target', '#addSkillsBModal');
    } else if (mode === 'delete') {
      this.deleteskillsback = skillsb;
      button.setAttribute('data-bs-target', '#deleteSkillsBModal');
    } else if (mode === 'edit') {
      this.editskillsback = skillsb;
      button.setAttribute('data-bs-target', '#editSkillsBModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddSkillsback(addForm: NgForm): void {
    document.getElementById('add-skillsb-form')?.click();
    this.skillsbService.addSkillsB(addForm.value).subscribe({
      next:(response:SkillsB) => {
        console.log(response);
        this.getSkillsback();
        addForm.reset();
      },
      error:(error:HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      },
    });
  }

  public onUpdateSkillsback(skillsb: SkillsB): void {
    this.editskillsback = skillsb;
    this.skillsbService.updateSkillsB(skillsb).subscribe({
      next:(response:SkillsB)=>{
        console.log(response);
        this.getSkillsback();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

  public onDeleteSkillsback(SkillsB: number):void{
    this.skillsbService.deleteSkillsB(SkillsB).subscribe({
      next:(response:void)=>{
        console.log(response);
        this.getSkillsback();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      },
    });
  }

}
