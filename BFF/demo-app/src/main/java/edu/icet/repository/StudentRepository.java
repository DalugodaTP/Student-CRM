package edu.icet.repository;

import edu.icet.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;


public interface StudentRepository extends CrudRepository<StudentEntity, Long> { //specify that this repository will deal with entities of type StudentEntity and the primary key type is Long.


}
