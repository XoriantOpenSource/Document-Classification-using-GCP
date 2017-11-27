import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { env } from '../environment'
import 'rxjs/add/operator/map';

@Injectable()
export class ClassificationServiceService {

  constructor(private _http: Http) { }
  uploadFile(form: FormData) {
    return this._http.post(env.url + "SpringBootRestApi/api/file", form).map(
      (response: Response) => response.json());
  }
}
