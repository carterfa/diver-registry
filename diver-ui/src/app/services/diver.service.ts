import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DiverService {

  constructor(private http:HttpClient) { }

  getDivers() {
    let token = localStorage.getItem('access_token');
    return this.http.get('/server/api/v1/divers',
    {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)}
    );
  }

  getDiver(id: number) {
    let token = localStorage.getItem('access_token');
     return this.http.get('/server/api/v1/divers/' + id,
     {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)}
     );
    }

  createDiverRegistration(diver){
    let body = JSON.stringify(diver);
    return this.http.post('/server/api/v1/divers', body, httpOptions);
  }

  login(diver){
    let body = JSON.stringify(diver);
    return this.http.post('/server/api/v1/divers/login', body, httpOptions);
  }
}
