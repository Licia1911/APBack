import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Proyectos } from '../models/proyectos';

@Injectable({
  providedIn: 'root'
})
export class ProyectosService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http:HttpClient) { }

  public getProyectos():Observable<Proyectos[]>{
    return this.http.get<Proyectos[]>(`${this.apiServerUrl}/api/proyectos`);
  }

  public addProyectos(proyectos: Proyectos):Observable<Proyectos>{
    return this.http.post<Proyectos>(`${this.apiServerUrl}/api/proyectos`, proyectos);
  }

  public updateProyectos(proyectos: Proyectos):Observable<Proyectos>{
    return this.http.put<Proyectos>(`${this.apiServerUrl}/api/proyectos`, proyectos);
  }

  public deleteProyectos(proyectosId: number):Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/api/proyecto/${proyectosId}`);
  }
}
