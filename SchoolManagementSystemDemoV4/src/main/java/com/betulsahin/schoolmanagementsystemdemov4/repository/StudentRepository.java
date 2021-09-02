package com.betulsahin.schoolmanagementsystemdemov4.repository;

import com.betulsahin.schoolmanagementsystemdemov4.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
