package com.codespells.Code.Spells.controller;

import com.codespells.Code.Spells.model.Course;
import com.codespells.Code.Spells.service.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourseController {

    @Autowired
    CourseServices courseServices;


    /**
     * controller for createUser
     * @return
     */
    @RequestMapping(value = "/createCourse",method = RequestMethod.GET)
    public ModelAndView createCourse(){
        ModelAndView modelAndView = new ModelAndView("CreateCourse");
        modelAndView.addObject("courseForm",new Course());

        return modelAndView;
    }


    /**
     * for inserting course into database
     * @param course
     * @return
     */
    @RequestMapping(value = "/addCourse", method = RequestMethod.POST)
    public ModelAndView addCourse(@ModelAttribute("courseForm") Course course) {
        Course requestedCourse = courseServices.getByName(course.getName());

        if (requestedCourse == null) {
            return new ModelAndView("redirect:/home");
        } else {

            return new ModelAndView("redirect:/availableCourse");

        }
    }


    @GetMapping(value = "/availableCourse")
    public ModelAndView availableCourse() {

        return new ModelAndView("Home");
    }

}
