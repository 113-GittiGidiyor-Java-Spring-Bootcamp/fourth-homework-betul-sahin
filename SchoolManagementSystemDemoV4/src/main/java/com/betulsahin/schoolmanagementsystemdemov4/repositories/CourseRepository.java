package com.betulsahin.schoolmanagementsystemdemov4.repositories;

import com.betulsahin.schoolmanagementsystemdemov4.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCode(String code);
}
