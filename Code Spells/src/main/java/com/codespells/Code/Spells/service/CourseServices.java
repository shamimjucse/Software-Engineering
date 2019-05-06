package com.codespells.Code.Spells.service;

import com.codespells.Code.Spells.model.Course;
import com.codespells.Code.Spells.model.User;


import java.util.List;

public interface CourseServices {

    public List<Course> getAllCourse();
    public Course getCourseByID(Integer id);
    public Course getByName(String Name);
    public void saveOrUpdateCourse(Course course);
    public void deleteCourse(Integer id);
}