import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SkillsF } from '../models/skillsf';


@Injectable({
  providedIn: 'root'
})
export class SkillsfService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getSkillsF():Observable<SkillsF[]>{
    return this.http.get<SkillsF[]>(`${this.apiServerUrl}/api/skillsF`);
  }


  public addSkillsF(skillsF: SkillsF):Observable<SkillsF>{
    return this.http.post<SkillsF>(`${this.apiServerUrl}/api/skillsF`, skillsF);
  }

  public updateSkillsF(skillsF: SkillsF):Observable<SkillsF>{
    return this.http.put<SkillsF>(`${this.apiServerUrl}/api/skillsF`, skillsF);
  }

  public deleteSkillsF(skillsFId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/skillsF/${skillsFId}`);
  }
}
