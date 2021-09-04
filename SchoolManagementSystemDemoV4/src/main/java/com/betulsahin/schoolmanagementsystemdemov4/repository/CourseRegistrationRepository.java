package com.betulsahin.schoolmanagementsystemdemov4.repository;

import com.betulsahin.schoolmanagementsystemdemov4.entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
    @Query("SELECT COUNT(cr) FROM CourseRegistration cr WHERE cr.course.id = ?1")
    int findStudentCountByCourse(long courseId);
}
