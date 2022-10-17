import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../models/educacion';

@Injectable({
  providedIn: 'root'
})
export class EducacionService {

  private apiServerUrl= 'http://localhost:8080';

  constructor(private http:HttpClient) { }

  public getEducation():Observable<Educacion[]>{
    return this.http.get<Educacion[]>(`${this.apiServerUrl}/api/educacion`);
  }

  public addEducation(educacion: Educacion):Observable<Educacion>{
    return this.http.post<Educacion>(`${this.apiServerUrl}/api/educacion`, educacion);
  }

  public updateEducation(educacion: Educacion):Observable<Educacion>{
    return this.http.put<Educacion>(`${this.apiServerUrl}/api/educacion`, educacion);
  }

  public deleteEducation(educacionId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/educacion/${educacionId}`);
  }
}
