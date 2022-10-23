import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SkillsB } from '../models/skillsb';

@Injectable({
  providedIn: 'root'
})
export class SkillsbService {

  private apiServerUrl= 'http://localhost:8080';

  constructor(private http:HttpClient) { }

  public getSkillsB():Observable<SkillsB[]>{
    return this.http.get<SkillsB[]>(`${this.apiServerUrl}/api/skillsB`);
  }


  public addSkillsB(skillsB: SkillsB):Observable<SkillsB>{
    return this.http.post<SkillsB>(`${this.apiServerUrl}/api/skillsB`, skillsB);
  }

  public updateSkillsB(skillsB: SkillsB):Observable<SkillsB>{
    return this.http.put<SkillsB>(`${this.apiServerUrl}/api/skillsB`, skillsB);
  }

  public deleteSkillsB(skillsBId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/skillsB/${skillsBId}`);
  }

}
