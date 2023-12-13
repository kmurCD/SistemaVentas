import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CiudadService {
 private API_SERVER = "http://localhost:8080/ciudad/"
  constructor(
    private httpclient: HttpClient
  ) { }

  public getAllCiudadByPais(idPais): Observable<any>{ //  captura id y envia 
    return  this.httpclient.get(this.API_SERVER+idPais)

  }
}
