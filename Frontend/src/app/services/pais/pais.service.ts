import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaisService {
  getSavePersona(value: any) {
    throw new Error('Method not implemented.');
  }
  savePersona(value: any) {
    throw new Error('Method not implemented.');
  }

  private API_SERVER = "http://localhost:8080/pais/"
  constructor(
    private httpclient: HttpClient
  ) { }

  public getAllPaises(): Observable<any>{
    return  this.httpclient.get(this.API_SERVER)

  }
  
}
