package com.betulsahin.schoolmanagementsystemdemov4.repository;

import com.betulsahin.schoolmanagementsystemdemov4.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByPhoneNumber(String phoneNumber);
}
