import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SkillsB } from 'src/app/models/skillsb';
import { SkillsbService } from 'src/app/services/skillsb.service';

@Component({
  selector: 'app-skills-b',
  templateUrl: './skills-b.component.html',
  styleUrls: ['./skills-b.component.css']
})
export class SkillsBComponent implements OnInit {

  public skillsback:SkillsB[]=[];

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

}
