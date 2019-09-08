import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Contato } from './domain/contato';

@Injectable({
  providedIn: 'root'
})
export class ContatosService {

  private dados: any;
  private API_URL = 'http://localhost:8080/servidor/api/contatos';
  constructor(public http: HttpClient) {
  }
   todosOsContatos() {
    return new Promise( resolve => {
      this.http.get(this.API_URL).
        subscribe( result => {
            resolve(result);
            // let data = result.json();
            // resolve(data);
        });
    });
  }
}
