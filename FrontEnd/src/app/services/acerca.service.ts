import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Persona } from '../models/persona';

@Injectable({
  providedIn: 'root'
})
export class AcercaService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getUser():Observable<Persona>{
    return this.http.get<Persona>(`${this.apiServerUrl}/api/persona/1`);
  }

  public updatePersona(persona: Persona):Observable<Persona>{
    return this.http.put<Persona>(`${this.apiServerUrl}/api/persona`, persona);
  }
}
