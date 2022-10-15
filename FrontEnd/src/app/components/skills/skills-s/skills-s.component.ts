import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { SkillsS } from 'src/app/models/skillss';
import { SkillssService } from 'src/app/services/skillss.service';

@Component({
  selector: 'app-skills-s',
  templateUrl: './skills-s.component.html',
  styleUrls: ['./skills-s.component.css']
})
export class SkillsSComponent implements OnInit {
  public skillssoft:SkillsS[]=[];

  constructor(private skillssService:SkillssService) { }

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

}
