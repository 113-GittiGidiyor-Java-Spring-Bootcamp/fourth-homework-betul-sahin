package com.betulsahin.schoolmanagementsystemdemov4.repository;

import com.betulsahin.schoolmanagementsystemdemov4.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
