import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent implements OnInit {

  //--To temporarily store data
  public anyStudent: any;

  public http;
  public studentList: any;
  public selectedStudent: any = {};

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

  deleteStudent() {
    //--Incorporate the studentId into the URL

    let apiUrl = "http://localhost:8080/student/" + this.selectedStudent.id;

    this.http.delete(apiUrl)
      .subscribe(data => {
        console.log(data);
        this.loadStudents();
      })
  }


  saveStudent() {

    this.http.post("http://localhost:8080/student/add", this.selectedStudent)
      .subscribe(data => {
        console.log(data);
        this.selectedStudent = {};
        this.loadStudents();
      })

  }

  setSelectedStudent(student: any) {
    this.selectedStudent = student;
    console.log(this.selectedStudent);
  }

}
