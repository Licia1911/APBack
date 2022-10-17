import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SkillsS } from '../models/skillss';

@Injectable({
  providedIn: 'root'
})
export class SkillssService {

  private apiServerUrl='http://localhost:8080';

  constructor(private http:HttpClient) { }

  public getSkillsS():Observable<SkillsS[]>{
    return this.http.get<SkillsS[]>(`${this.apiServerUrl}/api/skillsS`);
  }


  public addSkillsS(skillsS: SkillsS):Observable<SkillsS>{
    return this.http.post<SkillsS>(`${this.apiServerUrl}/api/skillsS`, skillsS);
  }

  public updateSkillsS(skillsS: SkillsS):Observable<SkillsS>{
    return this.http.put<SkillsS>(`${this.apiServerUrl}/api/skillsS`, skillsS);
  }

  public deleteSkillsS(skillsSId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/skillsS/${skillsSId}`);
  }
}
