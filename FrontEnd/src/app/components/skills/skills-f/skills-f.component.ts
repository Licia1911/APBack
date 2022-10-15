import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SkillsF } from 'src/app/models/skillsf';
import { SkillsfService } from 'src/app/services/skillsf.service';

@Component({
  selector: 'app-skills-f',
  templateUrl: './skills-f.component.html',
  styleUrls: ['./skills-f.component.css']
})
export class SkillsFComponent implements OnInit {
  public skillsfront:SkillsF[]=[];

  constructor(private skillsfService:SkillsfService) { }

  ngOnInit(): void {
    this.getSkillsfront();
  }

  public getSkillsfront():void{
    this.skillsfService.getSkillsF().subscribe({
      next:(Response:SkillsF[])=>{
        this.skillsfront=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
