import {Component} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrl: './registration.component.css'
})
export class RegistrationComponent {

  public isSubmissionDisabled = false;

  private http;

  // Dependency injection from constructor
  constructor(private httpClient: HttpClient) {
    this.http = httpClient;
  }

  // Primary objective of this component is to capture data and send it via http protocol

  //--create the JSON object and store into a reference object
  public student = {
    firstName : null,
    lastName : null,
    contactNumber : null
  }

    //--then grab value from input field and set to this object

  //--trigger the API call (url, JSON body)
  createStudent() {
    this.isSubmissionDisabled = true;
    this.http.post("http://localhost:8080/student/add", this.student)
      .subscribe(data => {
        this.isSubmissionDisabled = false;
        //--trigger a log to indicate successful post
        console.log(data);
      })
  }


}
