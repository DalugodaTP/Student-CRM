import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {
  //--life cycle method


  public http;
  public studentList: any;

  constructor(private httpClient: HttpClient) {
    this.http = httpClient;
  }

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
