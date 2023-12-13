import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private API_SERVER = "http://localhost:8080/persona/"
  constructor(
    private httpclient: HttpClient
  ) { }

  public getAllPersonas(): Observable<any> {
    return this.httpclient.get(this.API_SERVER)
  }

  public getSavePersona(persona:any): Observable<any> {
    return this.httpclient.post(this.API_SERVER, persona)
  }

  public getpersona(id): Observable<any> {
    return this.httpclient.get(this.API_SERVER+id)
  }
  public getUpdatePersona(id): Observable<any> {
    return this.httpclient.get(this.API_SERVER + id)
  }

  public getDeletePersona(id): Observable<any> {
    return this.httpclient.delete(this.API_SERVER + id)
  }
}
