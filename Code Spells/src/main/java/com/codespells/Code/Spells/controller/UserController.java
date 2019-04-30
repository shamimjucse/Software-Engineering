package com.codespells.Code.Spells.controller;

import com.codespells.Code.Spells.model.User;
import com.codespells.Code.Spells.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserServices userServices;

    /**
     * controller for login
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView userLogin(){
        ModelAndView modelAndView = new ModelAndView("UserLoginPage");
        modelAndView.addObject("userForm",new User());

        return modelAndView;
    }

    /**
     * for authentication login
     * @param user
     * @return
     */
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView authenticationLogin(@ModelAttribute("userForm") User user){
        User requestedUser = userServices.getByEmail(user.getEmail());

        if (requestedUser == null || !requestedUser.getPassword().equals(user.getPassword())) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("redirect:/dashboard");
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard() {

        return new ModelAndView("Home");
    }
}
