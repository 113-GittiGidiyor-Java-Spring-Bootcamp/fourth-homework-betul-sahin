package com.betulsahin.schoolmanagementsystemdemov4.repository;

import com.betulsahin.schoolmanagementsystemdemov4.entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration, Long> {
}
