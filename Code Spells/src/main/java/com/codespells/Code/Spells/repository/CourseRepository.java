package com.codespells.Code.Spells.repository;

import com.codespells.Code.Spells.model.Course;
import com.codespells.Code.Spells.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    public Course findByName (String email);
}
