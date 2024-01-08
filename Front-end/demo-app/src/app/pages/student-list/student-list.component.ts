import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {

  //--To temporarily store data
  public deleteStudent: any;
  public updateStudent: any;

  public http;
  public studentList: any;

  constructor(private httpClient: HttpClient) {
    this.http = httpClient;
  }

  //--life cycle method
  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents() {
    this.http.get("http://localhost:8080/student/list")
      .subscribe((data: any) => {
        console.log(data)
        // insert the retrieved data into the variable
        this.studentList = data;
      })
  }
}
