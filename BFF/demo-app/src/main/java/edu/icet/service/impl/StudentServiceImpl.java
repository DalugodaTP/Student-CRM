package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.dto.Student;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;


    @Autowired
    ObjectMapper mapper;

    public List<Student> getStudentList() {
        //--create a new list for controller layer
        List<Student> list = new ArrayList<>();
        //--return the list of students from the database
        Iterable<StudentEntity> studentList = studentRepository.findAll();
        //--now return the list after mapping it into a student before sending to controller layer
        Iterator<StudentEntity> iterator = studentList.iterator();

        while(iterator.hasNext()){
            //--capture the item in next
            StudentEntity entity = iterator.next();
            //--java reflection
            Student student = mapper.convertValue(entity, Student.class);
            list.add(student);
        }
        return list;

    }

    @Override
    public Student getStudentById(Long studentId) {
        //--capture the entity search by the id
        StudentEntity studentEntity = studentRepository.findById(studentId).get();
        //--map it and return the student for display
        return mapper.convertValue(studentEntity, Student.class);
    }

    public StudentEntity addStudent(@RequestBody Student student) {
        //Model to Entity Conversion
        StudentEntity entity = mapper.convertValue(student, StudentEntity.class);

        //Saving Data
        return studentRepository.save(entity);
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        //--Model to Entity Conversion
        StudentEntity entity =
                mapper.convertValue(student, StudentEntity.class);
        //--capture the entity search by the id
        StudentEntity studentEntity = studentRepository.findById(studentId).get();

        //--map the values of the student into the studentEntity
        if (Objects.nonNull(entity.getFirstName()) && !"".equalsIgnoreCase(entity.getFirstName())){
            studentEntity.setFirstName(entity.getFirstName());
        }

        if (Objects.nonNull(entity.getLastName()) && !"".equalsIgnoreCase(entity.getLastName())){
            studentEntity.setLastName(entity.getLastName());
        }

        if (Objects.nonNull(entity.getContactNumber()) && !"".equalsIgnoreCase(entity.getContactNumber())){
            studentEntity.setContactNumber(entity.getContactNumber());
        }

        StudentEntity save = studentRepository.save(studentEntity);

        return mapper.convertValue(save, Student.class);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public boolean removeStudent(Long studentId){
        //--validation step
        Optional<StudentEntity> studentEntityOptional =
                studentRepository.findById(studentId);

        if (studentEntityOptional.isPresent()){
            studentRepository.deleteById(studentId);
            return true;
        }
        return false;
    }


}
