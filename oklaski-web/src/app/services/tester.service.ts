import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {TesterBug} from "../types/tester-bug";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TesterService {

  BASE_PATH: string = "localhost:8080/tester";

  constructor(private http: HttpClient) { }

  getTestersByBugs(countriesCriteria: string[], devicesCriteria: string[]): Observable<TesterBug[]> {
    return this.http.get<TesterBug[]>(`${this.BASE_PATH}/byBugs/${countriesCriteria.join(',')}/${devicesCriteria.join(',')}`);
  }
}
