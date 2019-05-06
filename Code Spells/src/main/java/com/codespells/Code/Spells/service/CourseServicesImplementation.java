package com.codespells.Code.Spells.service;

import com.codespells.Code.Spells.model.Course;
import com.codespells.Code.Spells.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CourseServicesImplementation implements CourseServices {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourse(){return (List<Course>)courseRepository.findAll();}
    @Override
    public Course getCourseByID(Integer id){return courseRepository.getOne(id);}
    @Override
    public Course getByName(String Name){return courseRepository.findByName(Name);}
    @Override
    public void saveOrUpdateCourse(Course course){courseRepository.save(course);}
    @Override
    public void deleteCourse(Integer id){courseRepository.deleteById(id);}
}
